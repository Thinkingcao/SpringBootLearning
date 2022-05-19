package com.example.springboot.guava.ratelimiter.annotation;


import java.lang.annotation.*;

/**
 * @Description 基于Guava限流注解
 * @Author jie.zhao
 * @Date 2019/8/19 9:49
 */
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
public @interface RateLimit {

    //资源名称
    String name() default "";

    // 限制每秒访问次数，默认最大即不限制
    double perSecond() default Double.MAX_VALUE;

}