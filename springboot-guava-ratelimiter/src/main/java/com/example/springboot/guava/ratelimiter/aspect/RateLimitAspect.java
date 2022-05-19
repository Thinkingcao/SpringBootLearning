package com.example.springboot.guava.ratelimiter.aspect;

import com.example.springboot.guava.ratelimiter.annotation.RateLimit;
import com.example.springboot.guava.ratelimiter.exception.RateLimiterException;
import com.google.common.util.concurrent.RateLimiter;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;
import java.util.concurrent.TimeUnit;
/**
 * @Description 基于Guava限流
 * @Author jie.zhao
 * @Date 2019/8/19 9:55
 */
@Slf4j
@Aspect
@Component
public class RateLimitAspect {

    RateLimiter guavaLateLimiter = RateLimiter.create(Double.MAX_VALUE);

    @Pointcut("@annotation(com.example.springboot.guava.ratelimiter.annotation.RateLimit)")
    public void pointcut() {
    }

    @Around("pointcut()")
    public Object around(ProceedingJoinPoint point) throws Throwable {
        //获取目标方法
        MethodSignature signature = (MethodSignature) point.getSignature();
        Method method = signature.getMethod();
        RateLimit limit = method.getAnnotation(RateLimit.class);
        guavaLateLimiter.setRate(limit.perSecond());

        //获取令牌桶中的一个令牌，最多等待1秒
        if (guavaLateLimiter.tryAcquire(1, 0, TimeUnit.SECONDS)) {
            return point.proceed();
        } else {
            log.error(limit.name() + " 接口并发量过大执行限流");
            throw new RateLimiterException("当前用户较多较拥挤,请稍后重试！");
        }
    }

}