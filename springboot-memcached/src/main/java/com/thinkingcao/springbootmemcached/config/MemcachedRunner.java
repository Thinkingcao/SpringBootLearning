package com.thinkingcao.springbootmemcached.config;

import lombok.extern.slf4j.Slf4j;
import net.spy.memcached.MemcachedClient;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.io.IOException;
import java.net.InetSocketAddress;

/**
 * <pre>
 * 初始化操作
 * @auther: cao_wencao
 * @date: 2019/2/22 11:11
 * </pre>
 */
@Component
@Slf4j
public class MemcachedRunner implements CommandLineRunner {

    @Resource
    private MemcacheSource memcacheSource;

    private MemcachedClient memcachedClient = null;


    /**
     * 初始化
     */
    @Override
    public void run(String... args) {
        String memcachedIp = memcacheSource.getIp();
        int memcachedPort = memcacheSource.getPort();
        try {
            //只采用单机模式，如果需要配置集群模式可用AddrUtil.getAddresses(servers),
            //可参考：https://blog.csdn.net/gtuu0123/article/details/4849905
            memcachedClient = new MemcachedClient(new InetSocketAddress(memcachedIp, memcachedPort));
            log.info("++++++++++++++++++++ Memcached 连接成功,Address:{}:{} ++++++++++++++++++++++", memcachedIp, memcachedPort);
        } catch (IOException e) {
            log.info("++++++++++++++++++++ Memcached 连接异常,Address:{}:{} ++++++++++++++++++++++{}", memcachedIp, memcachedPort, e);
        }
    }


    public MemcachedClient getClient() {
        return memcachedClient;
    }

}