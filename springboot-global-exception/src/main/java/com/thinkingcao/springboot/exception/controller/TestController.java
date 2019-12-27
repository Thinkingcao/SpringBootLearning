package com.thinkingcao.springboot.exception.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @desc:
 * @author: cao_wencao
 * @date: 2019-12-27 16:40
 */
@RequestMapping("/order")
@Controller
public class TestController{

    // @RequestMapping("/test")
    // @ResponseBody
    // public String test() {
    //     int a = 2 / 0;
    //     return "test 500异常";
    // }


    @RequestMapping("/testPage")
    public String testPage(){
        return "test";
    }
}

