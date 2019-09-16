package com.yb.session.controller;
import com.yb.base.utils.base.controller.BaseController;
import com.yb.base.utils.base.vo.response.BaseRespons;
import com.yb.base.utils.json.JSONUtils;
import com.yb.session.GenerateImage;
import com.yb.session.ImageCode;
import com.yb.session.TokenBean;
import com.yb.session.TokenService;
import com.yb.user.pojo.Resources;
import com.yb.user.pojo.User;
import com.yb.user.pojo.vo.Menu;
import com.yb.user.service.ResourcesService;
import com.yb.user.service.UserService;
import io.swagger.annotations.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Controller
@Api(description = "授权认证模块")
public class AuthenticationController extends BaseController {

    @Autowired
    private UserService userService;

    @Autowired
    private ResourcesService resourcesService;

    @Autowired
    private TokenService tokenService;

    @ApiOperation(value = "获取验证码", notes = "会话id  UUID")
    @ApiImplicitParams({ @ApiImplicitParam(paramType = "query",dataType = "String", name = "sessionId", value = "前端生成唯一会话id建议用uuid", required = true) })
    @GetMapping("/code/image")
    public void createCode(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String sessionid = request.getParameter("sessionId");
        if(sessionid != null){
            TokenBean tokenBean = new TokenBean(60);
            ImageCode imageCode = GenerateImage.generate();
            tokenBean.setAttribute("code",imageCode.getCode());
            tokenService.updateSessionBean(sessionid,tokenBean);
            ImageIO.write(imageCode.getImage(), "JPEG", response.getOutputStream());
        }
    }

    @ApiOperation(value = "用户登录")
    @ApiImplicitParams({ @ApiImplicitParam(paramType = "query", dataType = "String", name = "username", value = "用户名", required = true),
            @ApiImplicitParam(paramType = "query", dataType = "String", name = "password", value = "密码需在前台md5", required = true),
            @ApiImplicitParam(paramType = "query", dataType = "String", name = "code", value = "验证码", required = true),
            @ApiImplicitParam(paramType = "query", dataType = "String", name = "sessionId", value = "获取验证码的sessionId", required = true)}
    )
    @PostMapping("/authentication/form")
    public @ResponseBody BaseRespons<String> login(HttpServletRequest request){

        String password = request.getParameter("password");
        if (password.isEmpty()){
            return RRException("500","密码不能为空");
        }
        String username = request.getParameter("username");
        if (username.isEmpty()){
            return RRException("500","用户名不能为空");
        }
        String code = request.getParameter("code");
        if(code.isEmpty()){
            return RRException("500","验证码不能为空");
        }
        String sessionId = request.getParameter("sessionId");
        if(sessionId.isEmpty()){
            return RRException("500","页面失效，刷新后再试");
        }
        TokenBean tokenBean = tokenService.getSessionBean(sessionId);
        if(tokenBean == null){
            return RRException("500","验证码失效");
        }
        if(!code.toUpperCase().equals(tokenBean.getAttribute("code").toUpperCase())){
            return RRException("500","验证码不正确");
        }


        User user = userService.queryUserByName(username);
        if(user == null){
            return RRException("500","用户不存在");
        }
        String userId = user.getId()+"";
        if(user.getLock() == 1){
            return RRException("500","密码输错次数过多，已锁定");
        }
        if(user.getPassWord().equals(password)){
            user.setPassWord("");

            TokenBean oldUser = tokenService.getSessionBean(userId);
            if(oldUser != null){
                String tokenId = oldUser.getToken();
                TokenBean oldToken = tokenService.getSessionBean(tokenId);
                oldToken.setAttribute("isEffective","1");
                tokenService.updateSessionBean(tokenId,oldToken);
            }

            tokenService.deleteFailCount(userId);
            tokenService.deleteSessionBean(sessionId);
            if(user.getLock() != 0){
                user.setLock(0);
                userService.updateUserLockStatus(user);
            }
            TokenBean tokenUser = new TokenBean(60*60*24);
            String token = UUID.randomUUID().toString();
            tokenUser.setToken(token);
            tokenUser.setAttribute("user",JSONUtils.objToJson(user));
            tokenUser.setAttribute("power", JSONUtils.objToJson(resourcesService.queryUserPowerByUserId(userId)));
            tokenUser.setAttribute("menu",JSONUtils.objToJson(getMenu(username)));
            tokenService.updateSessionBean(userId,tokenUser);

            TokenBean curToken = new TokenBean(60*30);
            curToken.setAttribute("isEffective","0");
            curToken.setAttribute("userCode",userId);
            tokenService.createSessionBean(token,curToken);
            curToken.setToken(token);
            return success(curToken);
        }else {
            tokenService.updateFailCount(userId);
            if(tokenService.isReachLimit(userId)){
                user.setLock(1);
                userService.updateUserLockStatus(user);
            }
            return RRException("500","密码不正确");
        }
    }

    public List<Menu> getMenu(String userName){
        List<Resources> resources = resourcesService.listResource(userName,"0");
        List<Menu> menus = new ArrayList<>();
        for (int i = resources.size()-1; i >=0 ; i--) {
            if(resources.get(i).getpId() == null){
                Menu menu = new Menu();
                menu.setId(resources.get(i).getId());
                menu.setMenuName(resources.get(i).getName());
                menus.add(menu);
                resources.remove(i);
            }
        }
        return initMunu(menus,resources);
    }

    @GetMapping("/authentication/me")
    @ApiOperation(value = "获取当前登录用户信息")
    @ResponseBody
    public BaseRespons<User> getCurrentUser(HttpServletRequest request){

        String token = request.getHeader("Authorization");
        if (token == null || token.isEmpty()) {
            return BaseRespons.error("401","token为null");
        }

        TokenBean tokenBean = tokenService.getSessionBean(token.replace("Bearer ", ""));
        String userId = tokenBean.getAttribute("userCode");
        TokenBean userBean = tokenService.getSessionBean(userId);
        User user = JSONUtils.toObject(userBean.getAttribute("user"),User.class);
        return success(user);
    }

    private List<Menu> initMunu(List<Menu> menus, List<Resources> resources){

        for (Menu menu:menus) {
            List<Menu> c_menus = new ArrayList<>();
            for (int i = resources.size()-1; i >=0 ; i--) {
                Resources res = resources.get(i);
                if(menu.getId().equals(res.getpId())){
                    Menu menu1 = new Menu();
                    menu1.setId(res.getId());
                    menu1.setUrl(res.getUrl());
                    menu1.setMenuName(res.getName());
                    c_menus.add(menu1);
                    resources.remove(i);
                }
            }
            if(c_menus.size() >0){
                menu.setHasNext(true);
                menu.setMenus(initMunu(c_menus,resources));
            }else{
                menu.setMenus(c_menus);
            }
        }

        return menus;
    }
}
