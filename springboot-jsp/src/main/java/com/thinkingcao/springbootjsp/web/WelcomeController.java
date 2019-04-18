package com.thinkingcao.springbootjsp.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Map;

@Controller
public class WelcomeController {
    @RequestMapping("/welcome")
    public String welcome(Map<String,Object> model) {
        model.put("message", "welcome to cxytiandi.com");
        return "welcome";
    }
}