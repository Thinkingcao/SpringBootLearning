package com.thinkingcao.encrypt.utils;

import com.alibaba.fastjson.JSON;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;
import org.springframework.util.CollectionUtils;

import java.util.concurrent.TimeUnit;

/**
 * Redis工具类
 */
@Component
public class RedisUtils {
    @Autowired
    private RedisTemplate<String, Object> redisTemplate;
    /**
     * 默认过期时长，单位：秒
     */
    public final static long DEFAULT_EXPIRE = 60 * 60 * 24;

    /**
     * 不设置过期时长
     */
    public final static long NOT_EXPIRE = -1;


    /**
     * 插入对象
     *
     * @param key   键
     * @param value 值
     * @author zmr
     */
    public void setObject(String key, Object value) {
        set(key, value, DEFAULT_EXPIRE);
    }

    /**
     * 删除缓存
     *
     * @param key 键
     * @author zmr
     */
    public void delete(String key) {
        redisTemplate.delete(key);
    }


    /**
     * 返回指定类型结果
     *
     * @param key   键
     * @param clazz 类型class
     * @return
     * @author zmr
     */
    public <T> T get(String key, Class<T> clazz) {
        String value = get(key);
        return value == null ? null : fromJson(value, clazz);
    }

    /**
     * Object转成JSON数据
     */
    public String toJson(Object object) {
        if (object instanceof Integer || object instanceof Long || object instanceof Float || object instanceof Double
                || object instanceof Boolean || object instanceof String) {
            return String.valueOf(object);
        }
        return JSON.toJSONString(object);
    }

    /**
     * JSON数据，转成Object
     */
    private <T> T fromJson(String json, Class<T> clazz) {
        return JSON.parseObject(json, clazz);
    }


    /**
     * 指定缓存失效时间
     *
     * @param key  键
     * @param time 时间(秒)
     * @return
     */

    public boolean expire(String key, long time) {

        try {

            if (time > 0) {

                redisTemplate.expire(key, time, TimeUnit.SECONDS);

            }

            return true;

        } catch (Exception e) {

            e.printStackTrace();

            return false;

        }

    }

    /**
     * 根据key 获取过期时间
     *
     * @param key 键 不能为null
     * @return 时间(秒) 返回0代表为永久有效
     */

    public long getExpire(String key) {

        return redisTemplate.getExpire(key, TimeUnit.SECONDS);

    }

    /**
     * 判断key是否存在
     *
     * @param key 键
     * @return true 存在 false不存在
     */

    public boolean hasKey(String key) {

        try {

            return redisTemplate.hasKey(key);

        } catch (Exception e) {

            e.printStackTrace();

            return false;

        }

    }

    /**
     * 删除缓存
     *
     * @param key 可以传一个值 或多个
     */

    @SuppressWarnings("unchecked")

    public void del(String... key) {

        if (key != null && key.length > 0) {

            if (key.length == 1) {

                redisTemplate.delete(key[0]);

            } else {

                redisTemplate.delete(CollectionUtils.arrayToList(key));

            }

        }

    }


    /**
     * 普通缓存获取
     *
     * @param key 键
     * @return 值
     */

    public String get(String key) {

        return key == null ? null : redisTemplate.opsForValue().get(key).toString();

    }

    /**
     * 普通缓存放入
     *
     * @param key   键
     *              94
     * @param value 值
     *              95
     * @return true成功 false失败
     */

    public boolean set(String key, Object value) {

        try {

            redisTemplate.opsForValue().set(key, value);

            return true;

        } catch (Exception e) {

            e.printStackTrace();

            return false;

        }

    }

    /**
     * 普通缓存放入并设置时间
     *
     * @param key   键
     *              111
     * @param value 值
     *              112
     * @param time  时间(秒) time要大于0 如果time小于等于0 将设置无限期
     *              113
     * @return true成功 false 失败
     */

    public boolean set(String key, Object value, long time) {

        try {

            if (time > 0) {

                redisTemplate.opsForValue().set(key, value, time, TimeUnit.SECONDS);

            } else {

                set(key, value);

            }

            return true;

        } catch (Exception e) {

            e.printStackTrace();

            return false;

        }

    }


}