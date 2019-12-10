package com.thinkingcao.springboot.scheduled.schedule;

import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @desc:
 * @author: cao_wencao
 * @date: 2019-12-10 16:50
 */
@Component
@Slf4j
public class ScheduledJob {

    //时间格式化
    private static final SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    //cron参数，传递一个cron表达式，可以按照cron的逻辑执行代码

    //每5秒执行一次，参数单位是毫秒
    @Scheduled(fixedRate = 5000)
    public void fixedRate() {
        log.info("fixedRate>>>："+format.format(new Date()));
    }

    //上次任务执行结束后，间隔5秒再执行下次任务，参数单位是毫秒
    @Scheduled(fixedDelay = 5000)
    public void fixedDelay() {
        log.info("fixedDelay>>>："+format.format(new Date()));
    }

    //initialDelay 表示首次任务启动的延迟时间，参数单位是毫秒
    @Scheduled(initialDelay = 5000,fixedDelay = 5000)
    public void initialDelay() {
        log.info("initialDelay>>>："+format.format(new Date()));
    }

    //每隔10秒执行一次
    @Scheduled(cron="0/10 * * * * *")
    public void startJob(){
        log.info("【每10秒执行一次Job任务，执行定时任务Job时间】=》：{}" ,format.format(new Date()));
    }
}
