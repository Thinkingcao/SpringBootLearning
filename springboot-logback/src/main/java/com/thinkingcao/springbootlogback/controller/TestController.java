package com.thinkingcao.springbootlogback.controller;

/**
 * @desc:
 * @author: cao_wencao
 * @date: 2019-09-09 17:44
 */

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@Slf4j
public class TestController {


    @RequestMapping("/show")
    @ResponseBody
    public String show() {
        log.debug("debug日志");

        log.info("info日志");

        log.warn("warn日志");

        log.error("error日志");
        return "show";
    }

}
