package com.thinkingcao.springbootsse.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.text.SimpleDateFormat;
import java.util.Random;

/**
 * @url:  http://127.0.0.1:8081/sse
 * @desc: 服务端主动推送:SSE (Server Send Event),单向推送
 * @author: cao_wencao
 * @date: 2019-12-02 16:18
 */
@RequestMapping
@Controller
public class SseMsgController {

    @RequestMapping("/sse")
    public String see() {
        return "sse";
    }

    //这里使用输出的媒体类型为text/event-stream，这是服务端的SSE的支持
    @RequestMapping(value = "/push", produces = "text/event-stream")
    @ResponseBody
    public String push() {
        SimpleDateFormat dateformat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String dateStr = dateformat.format(System.currentTimeMillis());
        Random r = new Random();
        try {
            //演示每5秒向浏览器推送随机消息
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return "data:Testing 服务端单向推送：=>" + dateStr+ "\n\n";
    }

}
