package com.yb.session.filter;

import com.yb.base.utils.base.vo.response.BaseRespons;
import com.yb.base.utils.json.JSONUtils;
import com.yb.session.TokenBean;
import com.yb.session.TokenService;
import com.yb.user.pojo.Resources;
import com.yb.user.service.ResourcesService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

public class LoginInterceptor implements HandlerInterceptor {

    private Logger logger = LoggerFactory.getLogger(LoginInterceptor.class);

    private boolean enableLoginInterceptor;

    private TokenService tokenService;

    private ResourcesService resourcesService;

    public LoginInterceptor(boolean enableLoginInterceptor, TokenService tokenService, ResourcesService resourcesService) {
        this.enableLoginInterceptor = enableLoginInterceptor;
        this.tokenService = tokenService;
        this.resourcesService = resourcesService;
    }

    /**
     * 在请求被处理之前调用
     * @param request
     * @param response
     * @param handler
     * @return
     * @throws Exception
     */
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        if(enableLoginInterceptor){
            BaseRespons baseRespons = parserAuthentication(request);
            if("success".equals(baseRespons.getData())){
                return true;
            }else {
                response.setStatus(HttpStatus.UNAUTHORIZED.value());
                response.setContentType("application/json;charset=UTF-8");
                response.getWriter().write(JSONUtils.objToJson(baseRespons));
                return false;
            }
        }
        return true;
    }

    private BaseRespons parserAuthentication(HttpServletRequest request){
        String token = request.getHeader("Authorization");
        if (token == null || token.isEmpty()) {
            return BaseRespons.error("401","token为null");
        }

        BaseRespons baseRespons = new BaseRespons();
        token = token.replace("Bearer ", "");
        TokenBean tokenBean = tokenService.getSessionBean(token);
        if(tokenBean == null){
            baseRespons.setState(0);
            baseRespons.setCode("500");
            baseRespons.setMgs("token不正确或以过期");
        }else {
            if("0".equals(tokenBean.getAttribute("isEffective"))){
                String url = request.getRequestURI();
                boolean b = false;
                List<Resources> resourcesList = resourcesService.listResource();

                for (Resources resources: resourcesList) {
                    if(url.equals(resources.getUrl())){
                        b = true;
                    }
                }
                if(!b){
                    baseRespons.setData("success");
                }else {
                    TokenBean userBean = tokenService.getSessionBean(tokenBean.getAttribute("userCode"));
                    List<Resources> per = JSONUtils.toArray(userBean.getAttribute("power"),Resources.class);
                    b = false;
                    for (Resources r:per) {
                        if(r.getUrl().equals(url)){
                            b = true;
                            break;
                        }
                    }
                    if(!b){
                        logger.error("您未拥有此权限 {}",url);
                        baseRespons.setState(0);
                        baseRespons.setCode("500");
                        baseRespons.setMgs("您未拥有此权限");
                    }else {
                        baseRespons.setData("success");
                    }
                }
                tokenBean.setExpire(60*30);
                tokenService.updateSessionBean(token,tokenBean);
            }else {
                baseRespons.setState(0);
                baseRespons.setCode("500");
                baseRespons.setMgs("用户已在别处登录，您被迫下线");
            }
        }

        return baseRespons;
    }

    /**
     * 在请求被处理后，视图渲染之前调用
     * @param request
     * @param response
     * @param handler
     * @param modelAndView
     * @throws Exception
     */
    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {

    }

    /**
     * 在整个请求结束后调用
     * @param request
     * @param response
     * @param handler
     * @param ex
     * @throws Exception
     */
    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {

    }
}
