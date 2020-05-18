package com.thinkingcao.encrypt.config;

import com.thinkingcao.encrypt.Inter.PermissionInterceptor;
import com.thinkingcao.encrypt.Inter.SignAuthInterceptor;
import com.thinkingcao.encrypt.listener.SessionListener;
import com.thinkingcao.encrypt.listener.WebContextListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnWebApplication;
import org.springframework.boot.web.servlet.ServletListenerRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * @desc:
 * @author: cao_wencao
 * @date: 2020-05-09 18:40
 */
@Configuration
@ConditionalOnWebApplication(type = ConditionalOnWebApplication.Type.SERVLET)
public class DefaultWebMvcConfigurer implements WebMvcConfigurer {

    @Autowired
    private PermissionInterceptor permissionInterceptor;

    @Autowired
    private SignAuthInterceptor signAuthInterceptor;

    /**
     * //1.加入的顺序就是拦截器执行的顺序，
     * //2.按顺序执行所有拦截器的preHandle
     * //3.所有的preHandle 执行完再执行全部postHandle 最后是postHandle
     */
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(signAuthInterceptor)
                .addPathPatterns("/**");             //所有请求都需要进行报文签名sign
        registry.addInterceptor(permissionInterceptor)
                .addPathPatterns("/**")
                .excludePathPatterns("api/user/login"); //排除登录Token拦截
    }


    // /**
    //  * 注册过滤器signAuthFilter bean到Spring容器
    //  */
    // @Bean("signAuthFilter")
    // @Order(0)
    // public FilterRegistrationBean<SignAuthFilter> signAuthFilter(){
    //     FilterRegistrationBean<SignAuthFilter> registrationBean = new FilterRegistrationBean<>();
    //     registrationBean.setFilter(new SignAuthFilter());
    //     registrationBean.setEnabled(true);
    //     registrationBean.addUrlPatterns("/*");
    //     registrationBean.setName("signAuthFilter");
    //     return registrationBean;
    // }

    /**
     * 注册webListenerDemo bean到Spring容器
     */
    @Bean("webListenerDemo")
    @Order(1)
    public ServletListenerRegistrationBean<WebContextListener> webListenerDemo(){
        ServletListenerRegistrationBean<WebContextListener> registrationBean = new ServletListenerRegistrationBean<>();
        registrationBean.setEnabled(true);
        registrationBean.setListener(new WebContextListener());
        return registrationBean;
    }

    /**
     * 注册sessionListener bean到Spring容器
     */
    @Bean("sessionListener")
    @Order(2)
    public ServletListenerRegistrationBean<SessionListener> sessionListener(){
        ServletListenerRegistrationBean<SessionListener> registrationBean = new ServletListenerRegistrationBean<>();
        registrationBean.setEnabled(true);
        registrationBean.setListener(new SessionListener());
        return registrationBean;
    }

}
