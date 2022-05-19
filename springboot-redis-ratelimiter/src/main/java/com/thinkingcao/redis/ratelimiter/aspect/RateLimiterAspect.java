package com.thinkingcao.redis.ratelimiter.aspect;

import com.thinkingcao.redis.ratelimiter.annotation.RateLimiter;
import com.thinkingcao.redis.ratelimiter.enums.RateLimiterEnum;
import com.thinkingcao.redis.ratelimiter.exception.RateLimiterException;
import com.thinkingcao.redis.ratelimiter.utils.IpUtils;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.reflect.MethodSignature;
import org.redisson.api.RedissonClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import javax.servlet.http.HttpServletRequest;
import java.lang.reflect.Method;
import java.util.concurrent.TimeUnit;

/**
 * @desc:  限流注解切面解析类
 * @author: cao_wencao
 * @date: 2022-05-18 21:18
 */
@Component
@Aspect
@Slf4j
public class RateLimiterAspect {

    private static final long COUNT_DEFAULT = 1;

    private static final int COUNT_STEP = 1;

    private static final int expireTime = 180;

    @Autowired
    private StringRedisTemplate redisTemplate;

    @Autowired
    private RedissonClient redissonClient;

    /**
     * IP作为限流，rateKey=rate_limit:127.0.0.1-com.thinkingcao.redis.ratelimiter.controller.ProductController-queryProducts
     * ID作为限流，rateKey=rate_limit:123456-com.thinkingcao.redis.ratelimiter.controller.ProductController-queryProducts
     * DEFAULT全局限流，rateKey=rate_limit-com.thinkingcao.redis.ratelimiter.controller.ProductController-queryProducts
     * @param point
     * @param rateLimiter
     */
    @Before("@annotation(rateLimiter)")
    public void doBefore(JoinPoint point, RateLimiter rateLimiter){
        String rateLimitKey = rateLimiter.rateLimitKey();
        int lockTime = rateLimiter.lockTime();
        int maxCount = rateLimiter.maxCount();
        String rateLimitCombineKey = getCombineKey(rateLimiter, point, rateLimitKey);
        String value = redisTemplate.opsForValue().get(rateLimitCombineKey);
        if (value == null){
            //如果拿到的结果为0，说明是第一次访问，此时就给当前 key 自增 1，然后设置一个过期时间。
            redisTemplate.opsForValue().set(rateLimitCombineKey, String.valueOf(COUNT_DEFAULT), expireTime, TimeUnit.SECONDS);
        }
        if (value != null){
            Long currentCount = Long.parseLong(value);
            if(currentCount >= maxCount) {
                //如果拿到的结果是一个数字，并且这个数字还大于 count，那就说明已经超过流量限制了，那么直接返回查询的结果即可
                redisTemplate.expire(rateLimitCombineKey,lockTime,TimeUnit.SECONDS);
                //当前请求达到限流次数上限后,这里直接抛出异常,全局异常处理器GlobalException会接管输出JSON格式给客户端
                throw new RateLimiterException("访问过于频繁，请稍候再试");
            }
            else if (value != null || !(Long.parseLong(value) >= maxCount)){
                Long newValue = redisTemplate.opsForValue().increment(rateLimitCombineKey,COUNT_STEP);
                if(newValue >= maxCount) {
                    //如果拿到的结果是一个数字，并且这个数字还大于 count，那就说明已经超过流量限制了，那么直接返回查询的结果即可
                    redisTemplate.expire(rateLimitCombineKey,lockTime,TimeUnit.SECONDS);
                }
            }
        }
        log.info("限制请求最大数'{}',限流锁定时间'{}',限流缓存key'{}'", maxCount,lockTime,rateLimitCombineKey);
    }


    /**
     * 获取限流组合key
     * @param rateLimiter
     * @param point
     * @return
     */
    public String getCombineKey(RateLimiter rateLimiter, JoinPoint point ,String rateLimitKey) {
        HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.currentRequestAttributes()).getRequest();
        MethodSignature signature = (MethodSignature) point.getSignature();
        Method method = signature.getMethod();
        Class<?> targetClass = method.getDeclaringClass();
        StringBuffer requestMethodPath = new StringBuffer().append(targetClass.getName()).append("-").append(method.getName());
        if (rateLimiter.limitType() == RateLimiterEnum.IP) {
            String ipAddr = IpUtils.getIpAddr(((ServletRequestAttributes) RequestContextHolder.currentRequestAttributes()).getRequest());
            rateLimitKey = String.format(rateLimitKey,ipAddr,requestMethodPath);
        }
        else if (rateLimiter.limitType() == RateLimiterEnum.USERID){
            String userId = request.getParameter("userId");
            rateLimitKey = String.format(rateLimitKey,userId,requestMethodPath);
        }
        else if (rateLimiter.limitType() == RateLimiterEnum.DEFAULT) {
            rateLimitKey = String.format(rateLimitKey,"",requestMethodPath).replace(":", "");
        }
        else if (rateLimiter.limitType() == RateLimiterEnum.MOBILE){
            String mobile = request.getParameter("mobile");
            rateLimitKey = String.format(rateLimitKey,mobile,requestMethodPath);
        }

        return rateLimitKey;
    }

}
