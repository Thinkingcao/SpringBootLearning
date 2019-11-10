package com.thinkingcao.springboothttps.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * <pre>
 * @desc:
 * @author: cao_wencao
 * @date:2019-11-08 22:48
 * @version: 1.0
 * </pre>
 */
@Controller
public class LoginController {

    @RequestMapping("/login")
    public String index() {
        return "login";
    }
}
