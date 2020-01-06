package com.thinkingcao.springboot.memcached.config;

/**
 * @desc:
 * @author: cao_wencao
 * @date: 2020-01-06 10:08
 */

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

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



    public String getServer() {
        return server;
    }

    public void setServer(String server) {
        this.server = server;
    }

    public Integer getOpTimeout() {
        return opTimeout;
    }

    public void setOpTimeout(Integer opTimeout) {
        this.opTimeout = opTimeout;
    }

    public Integer getPoolSize() {
        return poolSize;
    }

    public void setPoolSize(Integer poolSize) {
        this.poolSize = poolSize;
    }

    public boolean isFailureMode() {
        return failureMode;
    }

    public void setFailureMode(boolean failureMode) {
        this.failureMode = failureMode;
    }

    public boolean isEnabled() {
        return enabled;
    }

    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }

}
