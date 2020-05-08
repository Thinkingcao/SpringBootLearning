package com.thinkingcao.springboot.activiti.controller;

import org.activiti.engine.ProcessEngine;
import org.activiti.engine.RepositoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @desc:
 * @author: cao_wencao
 * @date: 2020-02-28 15:41
 */
@Controller
public class PageController {
	
	@Autowired
	private ProcessEngine processEngine;
	
	@Autowired
	private RepositoryService repositoryService;

    /**
     * 跳转编辑器页面
     * @return
     */
    @GetMapping("editor")
    public String editor(){
        return "modeler";
    }
    
    @RequestMapping("getService")
    @ResponseBody
    public String getService() {
    	System.out.println(repositoryService);
    	System.out.println(processEngine.getRuntimeService().toString());
    	return repositoryService.toString()+ "-----------"+ processEngine.getRuntimeService().toString();
    }
}
