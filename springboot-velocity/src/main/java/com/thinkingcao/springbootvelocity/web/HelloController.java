package com.thinkingcao.springbootvelocity.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Map;
  
/** 
 * 测试velocity; 
 * @author Angel -- 守护天使 
 * @version v.0.1 
 * @date 2016年10月4日 
 */  
@Controller  
public class HelloController {  
      
    @RequestMapping("/hello")  
    public String hello(Map<String,Object> map){  
        map.put("name", "[Angel -- 守护天使]");  
        return "velocity/index";
    }  
      
}  