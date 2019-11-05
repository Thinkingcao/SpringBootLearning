package com.thinkingcao.springbootmybatisplus.config;

import com.baomidou.mybatisplus.extension.plugins.PaginationInterceptor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @desc: Mybatis-Plus配置
 * @author: cao_wencao
 * @date: 2019-09-26 17:23
 */

@Configuration
public class MyBatisPlusConfig {

    /**
     * 分页拦截器插件
     */
    @Bean
    public PaginationInterceptor paginationInterceptor() {
        return new PaginationInterceptor();
    }


}
