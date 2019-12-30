package com.thinkingcao.springbootredistemplate.utils;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Component;

import java.util.concurrent.TimeUnit;

/**
 * @desc: 将操作String的StringCacheUtil注入到Spring容器，交给Spring管理
 * @author: cao_wencao
 * @date: 2019-12-30 17:38
 */
@Component
public class StringCacheUtil {

    @Autowired
    private StringRedisTemplate redisTemplate;

    /**
     * 实现命令：SET key value，设置一个key-value（将字符串值 value关联到 key）
     *
     * @param key
     * @param value
     */
    public void setValue(String key, String value) {
        redisTemplate.opsForValue().set(key, value);
    }

    /**
     * 实现命令：SET key value EX seconds，设置key-value和超时时间（秒）
     *
     * @param key
     * @param value
     * @param timeout （以秒为单位）
     */
    public void setValue(String key, String value, long timeout) {
        redisTemplate.opsForValue().set(key, value, timeout, TimeUnit.SECONDS);
    }

    /**
     * 实现命令：DEL key，删除一个key
     *
     * @param key
     */
    public void delKey(String key) {
        redisTemplate.delete(key);
    }

    /**
     * 实现命令：DEL key，删除一个key
     *
     * @param key
     */
    public boolean existKey(String key) {
        return redisTemplate.hasKey(key);
    }

    /**
     * 实现命令：GET key，返回 key所关联的字符串值。
     *
     * @param key
     * @return value
     */
    public String getValue(String key) {
        return redisTemplate.opsForValue().get(key);
    }

    /**
     * 实现命令：TTL key，以秒为单位，返回给定 key的剩余生存时间(TTL, time to live)。
     *
     * @param key
     * @return
     */
    public long getRemainingTime(String key) {
        return redisTemplate.getExpire(key);
    }

}
