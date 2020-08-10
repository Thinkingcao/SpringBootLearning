package com.thinkingcao.quartz.config;

import com.thinkingcao.quartz.task.TaskQuartz;
import org.quartz.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @desc: Quarta任务调度配置类
 * @author: cao_wencao
 * @date: 2020-08-10 20:43
 */
@Configuration
public class QuzrtzConfig {

    //使用jobDetail包装job
    @Bean
    public JobDetail myJobDetail() {
        return JobBuilder.newJob(TaskQuartz.class)
                .withIdentity("taskQuartz")
                .storeDurably()
                .build();
    }

    //把jobDetail注册到trigger上去,并设置定时任务执行策略
    @Bean
    public Trigger myJobTrigger() {
        SimpleScheduleBuilder scheduleBuilder = SimpleScheduleBuilder.simpleSchedule()
                .withIntervalInSeconds(15)
                .repeatForever();

        return TriggerBuilder.newTrigger()
                .forJob(myJobDetail())
                .withIdentity("myJobTrigger")
                .withSchedule(scheduleBuilder)
                .build();
    }

}
