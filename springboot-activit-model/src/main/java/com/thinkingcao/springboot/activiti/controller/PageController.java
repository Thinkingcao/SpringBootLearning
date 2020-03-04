package com.thinkingcao.springboot.activiti.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * @desc:
 * @author: cao_wencao
 * @date: 2020-02-28 15:41
 */
@Controller
public class PageController {

    /**
     * 跳转编辑器页面
     * @return
     */
    @GetMapping("editor")
    public String editor(){
        return "modeler";
    }
}
