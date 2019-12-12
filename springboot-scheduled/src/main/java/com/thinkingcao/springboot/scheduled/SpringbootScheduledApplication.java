package com.thinkingcao.springboot.scheduled;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

/**
 * <pre>
 * @desc: 启动类- 启用定时任务 @EnableScheduling
 * @auth: cao_wencao
 * @date: 2019/12/11 0:07
 * </pre>
 */
@SpringBootApplication
@EnableScheduling
public class SpringbootScheduledApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringbootScheduledApplication.class, args);
    }

}
