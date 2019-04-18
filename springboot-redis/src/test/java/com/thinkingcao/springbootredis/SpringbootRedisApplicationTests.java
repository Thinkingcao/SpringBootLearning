package com.thinkingcao.springbootredis;

import com.thinkingcao.springbootredis.dao.RedisDao;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
@Slf4j
public class SpringbootRedisApplicationTests {

    @Test
    public void contextLoads() {
    }


    @Autowired
    RedisDao redisDao;
    @Test
    public void testRedis(){
        redisDao.setKey("name","Thinkingcao");
        redisDao.setKey("age","18");
        log.info(redisDao.getValue("name"));
        log.info(redisDao.getValue("age"));
    }
}
