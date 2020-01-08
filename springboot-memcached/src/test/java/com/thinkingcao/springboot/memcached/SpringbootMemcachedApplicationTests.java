package com.thinkingcao.springboot.memcached;

import net.rubyeye.xmemcached.MemcachedClient;
import net.rubyeye.xmemcached.exception.MemcachedException;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.concurrent.TimeoutException;

@SpringBootTest
class SpringbootMemcachedApplicationTests {

    @Autowired
    private MemcachedClient memcachedClient;

    @Test
    void contextLoads() throws InterruptedException, MemcachedException, TimeoutException {
        System.out.println(memcachedClient.set("111", 0, "你好啊"));
        System.out.println(memcachedClient.get("111").toString());
    }

}
