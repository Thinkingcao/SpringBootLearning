package com.thinkingcao.springboot.controller;

import cn.wechat.boot.autoconfigure.service.WxDemoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @desc:
 * @author: cao_wencao
 * @date: 2020-08-25 16:51
 */
@RestController
public class DemoController {

    @Autowired
    private WxDemoService wxDemoService;

    @RequestMapping("/hello")
    public String hello(){
        String msg = wxDemoService.initLoader("你好");
        return msg;
    }
}
