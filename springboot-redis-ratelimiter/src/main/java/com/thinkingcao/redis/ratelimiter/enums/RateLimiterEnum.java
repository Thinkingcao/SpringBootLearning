package com.thinkingcao.redis.ratelimiter.enums;

/**
 * @desc:
 * @author: cao_wencao
 * @date: 2022-05-18 21:05
 */
public enum RateLimiterEnum {

    /**
     * 默认策略全局限流
     */
    DEFAULT,

    /**
     * 根据请求者IP进行限流
     */
    IP,

    /**
     * userID
     */
    USERID
}
