package com.thinkingcao.springboot.token;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.redis.repository.configuration.EnableRedisRepositories;
// SpringBoot通过Spring Data Redis 组件封装了对Redis的访问，整体上分为两种方式 RedisTemplate 和 Redis Repository,
@SpringBootApplication
@EnableRedisRepositories  //使用CrudRepository 类似jpa一样的效果,CRUD操作将会操作redis中的数据
public class SpringbootTokenApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringbootTokenApplication.class, args);
    }

}
