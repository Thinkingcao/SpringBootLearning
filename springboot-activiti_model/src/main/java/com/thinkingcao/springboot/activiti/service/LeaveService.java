package com.thinkingcao.springboot.activiti.service;

import org.activiti.bpmn.model.BpmnModel;
import org.activiti.engine.ProcessEngine;
import org.activiti.engine.RepositoryService;
import org.activiti.engine.RuntimeService;
import org.activiti.engine.impl.context.Context;
import org.activiti.spring.ProcessEngineFactoryBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

/**
 * @desc:
 * @author: cao_wencao
 * @date: 2020-01-09 16:10
 */
@Service
public class LeaveService {

    @Autowired(required = false)
    private RepositoryService repositoryService;

    @Autowired(required = false)
    private ProcessEngineFactoryBean processEngineFactory;

    @Autowired(required = false)
    private RuntimeService runtimeService;

    @Autowired(required = false)
    private ProcessEngine processEngine;


    // 获取流程图 执行到哪里红色显示
    public InputStream tracePhoto(String processDefinitionId, String executionId) {
        // ProcessInstance processInstance = runtimeService.createProcessInstanceQuery().processInstanceId(executionId).singleResult();
        BpmnModel bpmnModel = repositoryService.getBpmnModel(processDefinitionId);

        List<String> activeActivityIds = new ArrayList();
        if (runtimeService.createExecutionQuery().executionId(executionId).count() > 0){
            activeActivityIds = runtimeService.getActiveActivityIds(executionId);
        }

        // 不使用spring请使用下面的两行代码
        // ProcessEngineImpl defaultProcessEngine = (ProcessEngineImpl)ProcessEngines.getDefaultProcessEngine();
        // Context.setProcessEngineConfiguration(defaultProcessEngine.getProcessEngineConfiguration());

        // 使用spring注入引擎请使用下面的这行代码
        Context.setProcessEngineConfiguration(processEngineFactory.getProcessEngineConfiguration());
        // return ProcessDiagramGenerator.generateDiagram(bpmnModel, "png", activeActivityIds);
        return processEngine.getProcessEngineConfiguration().getProcessDiagramGenerator()
                .generateDiagram(bpmnModel, "png", activeActivityIds);
    }
}
