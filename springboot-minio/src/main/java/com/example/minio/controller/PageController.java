package com.example.minio.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @desc:  页面跳转
 * @author: cao_wencao
 * @date: 2020-11-20 10:53
 */
@Controller
public class PageController {

    @RequestMapping("/toPage")
    public String toPage(){
     return "upload";
    }
}
