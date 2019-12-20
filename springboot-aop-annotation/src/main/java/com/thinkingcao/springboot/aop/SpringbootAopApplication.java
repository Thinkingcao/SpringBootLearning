package com.thinkingcao.springboot.aop;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan(value = "com.thinkingcao.springboot.aop.mapper")
public class SpringbootAopApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringbootAopApplication.class, args);
    }

}
