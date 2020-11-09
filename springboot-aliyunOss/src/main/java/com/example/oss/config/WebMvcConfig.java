package com.example.oss.config;

import com.example.oss.filter.LoginInterceptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.util.ArrayList;
import java.util.List;

/**
 * @desc:  拦截器放行Swagger相关访问资源
 * @author: cao_wencao
 * @date: 2020-11-06 16:33
 */
@Configuration
public class WebMvcConfig implements WebMvcConfigurer {
    @Autowired
    private LoginInterceptor loginInterceptor;

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        InterceptorRegistration ir = registry.addInterceptor(loginInterceptor);
        // 拦截路径
        ir.addPathPatterns("/*");
        // 不拦截路径
        List<String> irs = new ArrayList<String>();
        irs.add("/login");
        irs.add("/api/*");
        // 开放knife4j
        irs.add("/doc.html");
        irs.add("/service-worker.js");
        irs.add("/swagger-resources");
        ir.excludePathPatterns(irs);
    }
}
