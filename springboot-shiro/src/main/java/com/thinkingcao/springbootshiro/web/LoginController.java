package com.thinkingcao.springbootshiro.web;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

/**
 * @desc:
 * @author: cao_wencao
 * @date: 2019-10-18 14:54
 */

@Controller
public class LoginController {

    /*
     * 登录请求接口
     */
    @PostMapping("/doLogin")
    public void doLogin(String username, String password) {
        Subject subject = SecurityUtils.getSubject();
        try {
            subject.login(new UsernamePasswordToken(username, password));
            System.out.println("登录成功!");
        } catch (AuthenticationException e) {
            e.printStackTrace();
            System.out.println("登录失败!");
        }
    }

    @GetMapping("/hello")
    public String hello() {
        return "hello";
    }


    @GetMapping("/login")
    public String login() {
        return "login";
    }

    @GetMapping("/unauth")
    public String unauth()
    {
        return "unauth";
    }
}
