package com.thinkingcao.redis.ratelimiter;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * SpringBoot启动类
 * {link:https://mp.weixin.qq.com/s/rzz2tgBBJpWz7gjmEfz2XQ}
 */
@SpringBootApplication
public class RedisRateLimiterApplication {

    public static void main(String[] args) {
        SpringApplication.run(RedisRateLimiterApplication.class, args);
    }

}
