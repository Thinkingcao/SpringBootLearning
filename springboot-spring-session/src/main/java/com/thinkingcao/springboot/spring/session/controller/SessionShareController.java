package com.thinkingcao.springboot.spring.session.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.Map;

/**
 * @desc: session共享控制器
 * @auth: cao_wencao
 * @date: 2020/1/19 10:25
 */
@RestController
@RequestMapping(value = "/session")
public class SessionShareController {

    @Value("${server.port}")
    private Integer port;


    /**
     * @desc: 设置值到session中
     * @auth: cao_wencao
     * @date: 2020/1/19 14:42
     */
    @GetMapping(value = "/setSessionValue")
    public Object setSessionValue(HttpSession session) {
        session.setAttribute("blog", "https://blog.csdn.net/thinkingcao");
        // 添加sessionID到Map
        Map<String, Object> map = new HashMap<>();
        map.put("sessionId", session.getId());
        map.put("port", port);
        return map;

    }

    /**
     * @desc: 从session中取出值
     * @auth: cao_wencao
     * @date: 2020/1/19 14:42
     */
    @GetMapping(value = "getSessionValue")
    public Object getSessionValue(HttpSession session) {
        Object value = session.getAttribute("blog");
        Map<String, Object> map = new HashMap<>();
        map.put("sessionId: ", session.getId());
        map.put("value: ", value);
        map.put("port: ", port);
        return map;

    }
}