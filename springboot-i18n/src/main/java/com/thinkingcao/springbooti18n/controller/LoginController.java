package com.thinkingcao.springbooti18n.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @desc:  login首页controller
 * @author: cao_wencao
 * @date: 2019-08-28 11:09
 */
@Controller
public class LoginController {

    @RequestMapping("/login")
    public String login(){
        return "login";
    }
}
