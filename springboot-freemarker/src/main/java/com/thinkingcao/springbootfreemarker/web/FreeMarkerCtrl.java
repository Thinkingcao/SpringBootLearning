package com.thinkingcao.springbootfreemarker.web;


import com.thinkingcao.springbootfreemarker.config.Resource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping(value = "/ftl")
public class FreeMarkerCtrl {

    @Autowired
    private Resource resource;

    @RequestMapping(value = "index")
    public String index(ModelMap map){
        map.addAttribute("resource",resource);
        return "freemarker/index";
    }

    @RequestMapping(value ="/center")
    public String  center(ModelMap map){
        map.put("users",parseUsers());
        map.put("title","用户列表");
        return "freemarker/center/center";
    }

    private List<Map> parseUsers(){
        List<Map> list= new ArrayList<>();
        for(int i=0;i<10;i++){
            Map map= new HashMap();
            map.put("name","admin_"+i);
            map.put("age",10+i);
            map.put("phone","1300291105"+i);
            list.add(map);
        }
        return list;
    }

}
