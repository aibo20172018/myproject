package com.yb.session.config;

import com.yb.session.TokenService;
import com.yb.session.filter.LoginInterceptor;
import com.yb.user.service.ResourcesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

@Configuration
public class LoginConfiguration extends WebMvcConfigurerAdapter {

    @Value("${login.interceptor.enable}")
    private boolean enableLoginInterceptor;


    @Autowired
    private TokenService tokenService;
    @Autowired
    private ResourcesService resourcesService;

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        // 注册拦截器
        registry.addInterceptor(new LoginInterceptor(enableLoginInterceptor,tokenService,resourcesService))
                .addPathPatterns("/**")
                .excludePathPatterns("/authentication/form","/code/image")
                .excludePathPatterns("/swagger-resources/**", "/webjars/**", "/v2/**", "/swagger-ui.html/**");
        super.addInterceptors(registry);
    }
}