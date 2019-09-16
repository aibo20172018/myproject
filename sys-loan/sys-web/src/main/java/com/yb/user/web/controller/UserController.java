package com.yb.user.web.controller;


import com.yb.base.utils.json.JSONUtils;
import com.yb.session.TokenBean;
import com.yb.session.TokenService;
import com.yb.user.pojo.Resources;
import com.yb.user.pojo.User;
import com.yb.user.pojo.vo.Menu;
import com.yb.user.pojo.vo.UserVo;
import com.yb.user.service.ResourcesService;
import com.yb.user.service.UserService;
import com.yb.base.utils.base.controller.BaseController;
import com.yb.base.utils.base.vo.response.BaseRespons;
import com.yb.base.utils.base.vo.response.PageResponsVO;
import com.yb.base.utils.paging.PageInfo;
import com.yb.base.utils.paging.Pagination;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.*;

/**
 * 
 * 
 * @author ybing
 * @email 
 * @date 2018-09-12 11:25:16
 */
@Api(description = "用户模块")
@RestController
@RequestMapping("/user")
public class  UserController extends BaseController {

    @Autowired
    private UserService userService;

    @Autowired
    private TokenService tokenService;

    @Autowired
    private ResourcesService resourcesService;

    @ApiOperation(value = "分页查询用户")
    @GetMapping(value = "/listUser.json")
    public PageResponsVO<UserVo> listUserData(User user, Pagination pagination){
        PageInfo<UserVo> pageInfo = new PageInfo<>();
        List<UserVo> list = userService.listPageUser(user,pagination);
        pageInfo.setList(list);
        pageInfo.setTotal(pagination.getTotal());
        return BaseRespons.ok(pageInfo);
    }

    @ApiOperation(value = "根据用户id获取用户")
    @GetMapping("/getUserByID.json")
    public BaseRespons getUserByID(Long userId){
        return success(userService.getUserByID(userId));
    }

    @ApiOperation(value = "添加用户")
    @PostMapping("/addUser.json")
    public BaseRespons addUser(User user,Long roleId){
        if(userService.queryUserByName(user.getUserName()) == null){
            user.setCreateTime(new Date());
            userService.addUser(user,roleId);
        }else {
            RRException("500","用户已存在");
        }
        return success("ok");
    }

    @ApiOperation(value = "修改用户状态")
    @ApiImplicitParams({ @ApiImplicitParam(paramType = "query", dataType = "String", name = "status", value = "是否锁定 0未锁定1锁定", required = true),
            @ApiImplicitParam(paramType = "query", dataType = "String", name = "id", value = "用户id", required = true)}
    )
    @PostMapping("/updateUserLockStatus.json")
    public BaseRespons updateUserLockStatus(Long id,int status){
        User user = new User();
        user.setId(id);
        user.setLock(status);
        userService.updateUserLockStatus(user);
        return success("ok");
    }

    @ApiOperation(value = "修改用户")
    @PostMapping("/updateUser.json")
    public BaseRespons updateUser(UserVo userVo){
        userService.updateUser(userVo);
        return success("ok");
    }

    @PostMapping("/deleteUsers.json")
    @ApiOperation(value = "",notes = "批量删除用户，用,隔开")
    public BaseRespons deleteUser(String userIds){
        userService.deleteUsers(userIds);
        return success("ok");
    }

    @PostMapping("/deleteUser.json")
    @ApiOperation(value = "根据用户id删除用户")
    public BaseRespons deleteUser(Long userId){
        userService.deleteUser(userId);
        return success("ok");
    }

    /**
     * 获取菜单
     * @return
     */
    @ApiOperation(value = "根据用户名称获取菜单")
    @GetMapping(value = "/getMenu.json")
    public BaseRespons<List<Menu>> getMenu(HttpServletRequest request){
        String token = request.getHeader("Authorization");
        if(token != null){
            TokenBean tokenBean = tokenService.getSessionBean(token.replace("Bearer ", ""));
            TokenBean userBean = tokenService.getSessionBean(tokenBean.getAttribute("userCode"));
            if(tokenBean != null){
                return  success(JSONUtils.toArray(userBean.getAttribute("menu"),Menu.class));
            }
        }
        return RRException("500","失败");
    }

    @ApiOperation(value = "获取菜单资源树")
    @GetMapping("/allResource.json")
    public List<Menu> getAllMenu(){
        List<Resources> resources = resourcesService.listResource();
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
        initMunu(menus,resources);
        return menus;
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
 
