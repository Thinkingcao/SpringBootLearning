package com.thinkingcao.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
 
@RestController
public class CacheController {
 
    @Autowired
    private StringRedisTemplate stringRedisTemplate;
 
    //添加
    @GetMapping(value="/redisAdd")
    public void saveRedis(){
        stringRedisTemplate.opsForValue().set("a","test");
    }
 
    //获取
    @GetMapping(value="/redisGet")
    public String getRedis(){
        return stringRedisTemplate.opsForValue().get("a");
    }
}
