package com.thinkingcao.encrypt.listener;

import lombok.extern.slf4j.Slf4j;

import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

/**
 * @desc: 监听Session，统计在线人数
 * @author: cao_wencao
 * @date: 2020-05-09 18:56
 */
@Slf4j
@WebListener
public class SessionListener implements HttpSessionListener {
    @Override
    public void sessionCreated(HttpSessionEvent se) {
       log.info(" -------- session create success -------- ");
    }

    @Override
    public void sessionDestroyed(HttpSessionEvent se) {
        log.info(" -------- session destroyed success -------- ");
    }
}
