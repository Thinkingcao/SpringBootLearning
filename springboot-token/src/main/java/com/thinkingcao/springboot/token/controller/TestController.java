package com.thinkingcao.springboot.token.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @desc:  测试类
 * @author: cao_wencao
 * @date: 2019-12-16 16:09
 */
@RestController
@RequestMapping("/test")
public class TestController {

    @GetMapping(value = "/testApiAuth")
    public String testApiAuth() {
        return "testApiAuth";
    }
}
