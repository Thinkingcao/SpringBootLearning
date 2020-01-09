package com.thinkingcao.springboot.activiti.controller;

import com.thinkingcao.springboot.activiti.service.LeaveService;
import lombok.extern.slf4j.Slf4j;
import org.activiti.engine.*;
import org.activiti.engine.impl.persistence.entity.ExecutionEntity;
import org.activiti.engine.runtime.ProcessInstance;
import org.activiti.engine.task.Task;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;
import java.io.InputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @desc: 请假流程
 * @author: cao_wencao
 * @date: 2020-01-09 15:53
 */
@Slf4j
@RestController
@RequestMapping("/leave")
public class LeaveController {

    @Autowired(required = false)
    private RuntimeService runtimeService;

    @Autowired(required = false)
    private TaskService taskService;

    @Autowired(required = false)
    private IdentityService identityService;

    @Autowired(required = false)
    private RepositoryService repositoryService;

    @Autowired(required = false)
    private ProcessEngine processEngine;

    @Autowired(required = false)
    private HistoryService historyService;

    @Autowired
    private LeaveService leaveService;


    /**
     * @desc: 发起流程
     * @auth: cao_wencao
     * @date: 2020/1/9 15:54
     */
    @RequestMapping("/initProcess")
    public String initProcess(){
        Map<String,Object> map = new HashMap<String,Object>();
        //流程图里写的${user} ，这里传进去user
        map.put("user","曹");
        //流程启动
        //指定流程的发起者 不指定发起者的字段就为空，注意跟审核人分开
        identityService.setAuthenticatedUserId("zhangsan");
        runtimeService.startProcessInstanceByKey("leave",map);
        ExecutionEntity pi = (ExecutionEntity) runtimeService.startProcessInstanceByKey("leave",map);
        log.info("启动流程成功！");

        Task task = taskService.createTaskQuery().processInstanceId(pi.getId()).singleResult();
        log.info("任务ID: {}", task.getId());
        log.info("任务的办理人: {}", task.getAssignee());
        log.info("任务名称: {}", task.getName());
        log.info("任务的创建时间: {}", task.getCreateTime());
        log.info("流程实例ID: {}", task.getProcessInstanceId());

        Map<String,Object> map2 = new HashMap<String,Object>();
        map2.put("users","lisi,wangwu");
        // 开启后，环节会走到发起请假请求，要完成这个环节，才能到下一个审核环节
        taskService.complete(task.getId(),map2);
        return "success";
    }


    /**
     * @desc: 根据taskid审核任务
     * @auth: cao_wencao
     * @date: 2020/1/9 16:07
     */
    @RequestMapping("/audit")
    public String audit(String taskId){

        Map<String,Object> map = new HashMap<String,Object>();
        //流程图里写的${users} ，这里传进去users
        map.put("users","lisi,wangwu");

        taskService.complete(taskId,map);
        return "success";
    }


    // 通过用户名查询该用户的所有任务
    @RequestMapping("/checkByUser")
    @ResponseBody
    public String checkByUser(String user){
        List<Task> tasks = taskService//与任务相关的Service
                .createTaskQuery()//创建一个任务查询对象
                .taskAssignee(user)
                .list();
        if(tasks !=null && tasks.size()>0){
            for(Task task:tasks){
                System.out.println("任务ID:"+task.getId());
                System.out.println("任务的办理人:"+task.getAssignee());
                System.out.println("任务名称:"+task.getName());
                System.out.println("任务的创建时间:"+task.getCreateTime());
                System.out.println("流程实例ID:"+task.getProcessInstanceId());
            }
        }
        return "success";
    }

    // 通过发起者查询该用户发起的所有任务
    @RequestMapping("/checkByInitiator")
    @ResponseBody
    public String checkByInitiator(String user){
        List<ProcessInstance> list = runtimeService.createProcessInstanceQuery().startedBy(user).list();  //获取该用户发起的所有流程实例
        // System.out.println(list.toString());
        for (ProcessInstance processInstance : list) {
            List<Task> tasks = taskService.createTaskQuery().processInstanceId(processInstance.getId()).list();
            if(tasks !=null && tasks.size()>0){
                for(Task task:tasks){
                    System.out.println("任务ID:"+task.getId());
                    System.out.println("任务的办理人:"+task.getAssignee());
                    System.out.println("任务名称:"+task.getName());
                    System.out.println("任务的创建时间:"+task.getCreateTime());
                    System.out.println("流程实例ID:"+task.getProcessInstanceId());
                }
            }
        }
        return "success";
    }



    /**
     * 获取流程图 执行到哪里高亮显示
     * @param procDefId 部署的流程id  在 act_re_procdef 这张表里
     * @param execId  要查询的流程执行的id（开启了一个流程就会生成一条执行的数据）  在 act_ru_execution 这张表里（该表下PROC_DEF_ID_字段可以判断哪个流程）
     * @param response
     * @throws Exception
     */
    @RequestMapping("/getActPic/{procDefId}/{execId}")
    public void  getActPic(@PathVariable("procDefId") String procDefId,
                           @PathVariable("execId") String execId, HttpServletResponse response)throws Exception {
        InputStream imageStream = leaveService.tracePhoto(procDefId, execId);
        // 输出资源内容到相应对象
        byte[] b = new byte[1024];
        int len;
        while ((len = imageStream.read(b, 0, 1024)) != -1) {
            response.getOutputStream().write(b, 0, len);
        }
    }
}
