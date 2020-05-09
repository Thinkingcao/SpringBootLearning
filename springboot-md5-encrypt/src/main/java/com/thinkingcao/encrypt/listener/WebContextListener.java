package com.thinkingcao.encrypt.listener;

import lombok.extern.slf4j.Slf4j;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

/**
 * @desc: web上下文监听器WebContextListener
 * @author: cao_wencao
 * @date: 2020-05-09 18:54
 */
@Slf4j
@WebListener
public class WebContextListener implements ServletContextListener {

    @Override
    public void contextInitialized(ServletContextEvent sce) {
        log.info("-------- 监听器WebListenerDemo Init -------- ");
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {
        log.info("-------- 监听器WebListenerDemo Destroy -------- ");
    }
}
