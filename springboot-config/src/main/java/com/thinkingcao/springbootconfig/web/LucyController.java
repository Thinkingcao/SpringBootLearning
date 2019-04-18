package com.thinkingcao.springbootconfig.web;

import com.thinkingcao.springbootconfig.entity.ConfigBean;
import com.thinkingcao.springbootconfig.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@EnableConfigurationProperties({ConfigBean.class})
public class LucyController {
    @Autowired
    private ConfigBean configBean;
    @Autowired
    private User user;


    @RequestMapping(value = "/lucy")
    public String miya() {
        return configBean.getGreeting() + " >>>>" + configBean.getName() + " >>>>" + configBean.getUuid() + " >>>>" + configBean.getMax();
    }


    @RequestMapping(value = "/user")
    public String user() {
        return user.getName() + user.getAge();
    }



}
    