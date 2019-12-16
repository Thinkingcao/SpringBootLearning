package com.thinkingcao.springboot.token.config;

import com.thinkingcao.springboot.token.interceptor.AuthorizationInterceptor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * <pre>
 * @desc: 将拦截器交给Spring容器管理
 * @author: cao_wencao
 * @date: 2019-12-16 22:21
 * @version: 1.0
 * </pre>
 */
@Configuration
public class WebMvcConfig implements WebMvcConfigurer {
    
    @Bean
    public AuthorizationInterceptor initAuthInterceptor() {
        return new AuthorizationInterceptor();
    }

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        //addPathPatterns : 拦截的路径 测试controller          excludePathPatterns： 不拦截的路径  登录controller
        registry.addInterceptor(initAuthInterceptor()).addPathPatterns("/test/**").excludePathPatterns("/login/**");
    }
}
