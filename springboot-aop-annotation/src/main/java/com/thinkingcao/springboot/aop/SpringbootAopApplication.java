package com.thinkingcao.springboot.aop;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @desc: 启动类； 注意: 注解式mybatis的sql需要加上@MapperScan扫描，xml形式的mybatis的sql不需要
 * @auth: cao_wencao
 * @date: 2019/12/20 17:14
 */
@SpringBootApplication
@MapperScan(value = "com.thinkingcao.springboot.aop.mapper")
public class SpringbootAopApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringbootAopApplication.class, args);
    }

}
