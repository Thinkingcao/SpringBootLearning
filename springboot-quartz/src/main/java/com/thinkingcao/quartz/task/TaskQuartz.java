package com.thinkingcao.quartz.task;

import com.thinkingcao.quartz.utils.DateUtils;
import org.quartz.DisallowConcurrentExecution;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.quartz.PersistJobDataAfterExecution;
import org.springframework.scheduling.quartz.QuartzJobBean;

/**
 * @desc: 定时任务逻辑实现类
 * @author: cao_wencao
 * @date: 2020-08-10 21:27
 */
@DisallowConcurrentExecution
@PersistJobDataAfterExecution
public class TaskQuartz extends QuartzJobBean {

    /**
     * @desc: 执行定时任务
     * @auth: cao_wencao
     * @date: 2020/8/10 21:28
     */
    @Override
    protected void executeInternal(JobExecutionContext jobExecutionContext) throws JobExecutionException {
        System.out.println("execute quartz task  at "+ DateUtils.dateTimeNow(DateUtils.YYYY_MM_DD_HH_MM_SS));

    }
}
