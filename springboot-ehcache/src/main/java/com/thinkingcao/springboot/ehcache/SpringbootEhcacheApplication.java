package com.thinkingcao.springboot.ehcache;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

/**
 * @desc: 使用@EnableCaching注解启用Spring缓存
 * @auth: cao_wencao
 * @date: 2019/12/12 17:47
 */
@SpringBootApplication
@EnableCaching
public class SpringbootEhcacheApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringbootEhcacheApplication.class, args);
    }

}
