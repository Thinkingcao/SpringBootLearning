package com.thinkingcao.springboot.memcached.config;

/**
 * @desc:
 * @author: cao_wencao
 * @date: 2020-01-06 10:08
 */

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Data
@Component
@ConfigurationProperties(prefix = "memcached")
public class MemcachedProperties {


    /**
     * 服务器
     */
    private String server;

    /**
     * 操作超时时间，可以被API覆盖
     */
    private Integer opTimeout;
    /**
     * 连接池大小
     */
    private Integer poolSize;

    /**
     * 是否开启失败模式
     */
    private boolean failureMode;

    /**
     * 是否使用memcached缓存
     */
    private boolean enabled;


}
