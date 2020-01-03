package com.thinkingcao.rocketmq;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
/**
 * <pre>
 * @desc: 生产者启动类
 * @auth: cao_wencao
 * @date: 2019/6/4 17:40
 * @param null
 * </pre>
 */
@SpringBootApplication
@Slf4j
public class SpringBootRocketmqProducerApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringBootRocketmqProducerApplication.class, args);
    }


}


