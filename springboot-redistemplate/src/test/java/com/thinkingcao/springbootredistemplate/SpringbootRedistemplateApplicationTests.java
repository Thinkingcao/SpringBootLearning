package com.thinkingcao.springbootredistemplate;

import com.thinkingcao.springbootredistemplate.utils.StringCacheUtil;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@Slf4j
@SpringBootTest
class SpringbootRedistemplateApplicationTests {


    @Autowired
    private StringCacheUtil stringCache;

    //测试get/set/delete key
    @Test
    public void setAndGet() {
        stringCache.setValue("Thinkingcao", "https://blog.csdn.net/Thinkingcao");
        String name = stringCache.getValue("name");
        log.info(name);
        stringCache.delKey("name");
        name = stringCache.getValue("name");
        log.info(name);
    }

    //测试设置有效时长的key
    @Test
    public void getRemainingTime() {
        stringCache.setValue("Thinkingcao", "https://blog.csdn.net/Thinkingcao", 40);
        log.info("剩余存活时间:{}秒", stringCache.getRemainingTime("hello"));
    }

    //测试过了有效时长的key，是否被删除
    @Test
    public void exist() {
        boolean i = stringCache.existKey("Thinkingcao");
        if (i) {
            log.info("该键还存在");
            log.info("剩余存活时间:{}秒", stringCache.getRemainingTime("Thinkingcao"));
        } else {
            log.info("该键已过期");
        }
    }

}
