package com.thinkingcao.springbootshiro.config.shiro;

import org.apache.shiro.mgt.SecurityManager;
import org.apache.shiro.realm.Realm;
import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * @desc: Shiro配置
 * @author: cao_wencao
 * @date: 2019-10-18 14:26
 */
@Configuration
public class ShiroConfig {

    @Bean
    public Realm myRealm(){
        return new MyRealm();
    }

    @Bean
    public DefaultWebSecurityManager securityManager() {
        DefaultWebSecurityManager securityManager = new DefaultWebSecurityManager();
        // 设置realm.
        securityManager.setRealm(myRealm());
        return securityManager;
    }

    @Bean
    public ShiroFilterFactoryBean shiroFilterFactoryBean(SecurityManager securityManager) {
        ShiroFilterFactoryBean shiroFilterFactoryBean = new ShiroFilterFactoryBean();
        // Shiro的核心安全接口,这个属性是必须的
        shiroFilterFactoryBean.setSecurityManager(securityManager);
        // 身份认证失败，则跳转到登录页面的配置
        shiroFilterFactoryBean.setLoginUrl("/login");
        // 登录成功页面
        shiroFilterFactoryBean.setSuccessUrl("/index");
        // 权限认证失败，则跳转到指定页面
        shiroFilterFactoryBean.setUnauthorizedUrl("/unauth");

        // Shiro连接约束配置，即过滤链的定义
        /**
         *  过滤规则（注意优先级）
         *  —anon 无需认证(登录)可访问
         *  —authc 必须认证才可访问
         *  —perms[标识] 拥有资源权限才可访问
         *  —role 拥有角色权限才可访问
         *  —user 认证和自动登录可访问
         */
        Map<String, String> map = new LinkedHashMap<>();
        map.put("/doLogin", "anon");
        map.put("/**", "authc");
        // 设置过滤规则
        shiroFilterFactoryBean.setFilterChainDefinitionMap(map);
        return shiroFilterFactoryBean;
    }
}
