package com.example.springboot;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * 启动类
 */
@SpringBootApplication
@MapperScan(basePackages = {"com.example.springboot.mapper1","com.example.springboot.mapper2"})//扫描mybatis的所有**Mapper接口文件
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

}
