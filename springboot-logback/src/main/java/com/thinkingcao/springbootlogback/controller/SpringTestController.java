package com.thinkingcao.springbootlogback.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @desc:
 * @author: cao_wencao
 * @date: 2019-09-09 17:56
 */
@Controller
@Slf4j
public class SpringTestController {

    @RequestMapping("/show")
    @ResponseBody
    public String ok() {
        log.debug("debug日志");

        log.info("info日志");

        log.warn("warn日志");

        log.error("error日志");
        return "ok";
    }
}

