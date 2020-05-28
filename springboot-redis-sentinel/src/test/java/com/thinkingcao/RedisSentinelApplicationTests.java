package com.thinkingcao;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;

@SpringBootTest
class RedisSentinelApplicationTests {
    @Autowired
    private RedisTemplate<String, String> redisTemplate;

    @Test
    void contextLoads() {
        this.redisTemplate.opsForValue().set("web", "aaaa");
        //this.redisTemplate.opsForValue().set("key", "cao大师");
        System.out.println("取出缓存的键值name : " + this.redisTemplate.opsForValue().get("web"));
       // System.out.println("取出缓存的键值key : " + this.redisTemplate.opsForValue().get("key"));
    }

}
