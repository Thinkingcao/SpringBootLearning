package com.thinkingcao.redis.ratelimiter.annotation;

import com.thinkingcao.redis.ratelimiter.enums.RateLimiterEnum;
import org.springframework.boot.autoconfigure.condition.ConditionalOnWebApplication;

import java.lang.annotation.*;

/**
 * @desc:
 * @author: cao_wencao
 * @date: 2022-05-18 21:08
 */
@Inherited
@Documented
@Target({ElementType.METHOD, ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@ConditionalOnWebApplication(type = ConditionalOnWebApplication.Type.SERVLET)
public @interface RateLimiter {

    /**
     * 限流key,用于Redis的key
     */
    String rateLimitKey() default "rate_limit:%s-%s";

    /**
     * 限流时间,单位秒
     */
    int lockTime() default 60;

    /**
     * 限流次数上限
     */
    int maxCount() default 100;

    /**
     * 限流类型
     */
    RateLimiterEnum limitType() default RateLimiterEnum.DEFAULT;

}
