package com.thinkingcao.springboot.aoplog.controller;

import com.google.common.collect.Maps;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

/**
 * @desc:
 * @author: cao_wencao
 * @date: 2019-12-26 15:50
 */
@RestController
@RequestMapping("/log")
public class HelloController {

    /**
     * @path: http://127.0.0.1:8080/log/hello?id=1
     * @desc: 正常请求场景
     * @auth: cao_wencao
     * @date: 2019/12/26 15:55
     */
    @RequestMapping("/hello")
    public Object hello(Integer id){
        Map<String,String> map = Maps.newHashMap();
        map.put("code", "200");
        map.put("msg","请求成功");
        map.put("data","hello 你好");
        return map;
    }


    /**
     * @path: http://127.0.0.1:8080/log/exception
     * @desc: 异常请求场景
     * @auth: cao_wencao
     * @date: 2019/12/26 15:56
     */
    @RequestMapping("/exception")
    public Object getException(){
        // 故意造出一个异常
        int a = 1/0;
        return a;
    }
}
