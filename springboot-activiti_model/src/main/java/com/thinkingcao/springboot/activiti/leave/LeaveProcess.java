package com.thinkingcao.springboot.activiti.leave;

import java.io.InputStream;
import java.util.List;
import java.util.zip.ZipInputStream;

import org.activiti.engine.ProcessEngine;
import org.activiti.engine.ProcessEngines;
import org.activiti.engine.RepositoryService;
import org.activiti.engine.RuntimeService;
import org.activiti.engine.TaskService;
import org.activiti.engine.repository.Deployment;
import org.activiti.engine.repository.DeploymentBuilder;
import org.activiti.engine.runtime.ProcessInstance;
import org.activiti.engine.task.Task;
import org.junit.Test;

import lombok.extern.slf4j.Slf4j;

/**
 * @Desc  模拟请假流程
 * @author cao_wencao
 * @date 2020年3月9日 下午6:00:42
 * @version V1.0
 */
@Slf4j
public class LeaveProcess {
	
	//执行这条语句会寻找类路径中activiti.cfg.xml文件，并根据文件中的配置构造ProcessEngine。
	private  ProcessEngine processEngine = ProcessEngines.getDefaultProcessEngine();

	//部署流程图-单个文件
	@Test
	public void deployProcess() {
		//得到流程部署Service
		RepositoryService repositoryService = this.processEngine.getRepositoryService();
		Deployment deploy = repositoryService
				.createDeployment()
				.name("请假流程001")
				.addClasspathResource("processes/leave.bpmn")
				.addClasspathResource("processes/leave.png")
				.deploy();
		log.info("【流程部署成功, 流程部署ID】: {}", deploy.getId());
		log.info("【流程部署成功, 流程部署name】: {}", deploy.getName());
		log.info("【流程部署成功, 流程部署key】: {}", deploy.getKey());
		log.info("【流程部署成功, 流程部署时间】: {}", deploy.getDeploymentTime());
	}
	
	//部署流程图-zip方式
	@Test
	public void deployProcessByZip() {
		RepositoryService repositoryService = this.processEngine.getRepositoryService();
		InputStream inputStream = this.getClass().getResourceAsStream("/processes/leave.zip");
		ZipInputStream zipInputStream = new ZipInputStream(inputStream);
		Deployment deployment = repositoryService
				.createDeployment()
				.name("请假流程002")
				.addZipInputStream(zipInputStream )
				.deploy();
		log.info("【流程部署成功, 流程部署ID】: {}", deployment.getId());
		log.info("【流程部署成功, 流程部署name】: {}", deployment.getName());
		log.info("【流程部署成功, 流程部署key】: {}", deployment.getKey());
		log.info("【流程部署成功, 流程部署时间】: {}", deployment.getDeploymentTime());
	}
	
	//启动流程
	@Test
	public void startProcess() {
	    RuntimeService runtimeService = this.processEngine.getRuntimeService();
	    String processDefinitionKey = "leaveProcess";
		ProcessInstance processInstance = runtimeService.startProcessInstanceByKey(processDefinitionKey);
		log.info("【流程启动成功，流程实例ID】: {}", processInstance.getId());
		log.info("【流程启动成功,流程定义ID】: {}", processInstance.getProcessDefinitionId());
		log.info("【流程启动成功,流程实例ID】: {}", processInstance.getProcessInstanceId());
		log.info("【流程启动成功，流程定义key】: {}", processInstance.getProcessDefinitionKey()); //对应图中的Id
		log.info("【流程启动成功,流程定义name】: {}", processInstance.getProcessDefinitionName());//对应图中的Name
	}
	
	//查询待办任务
	@Test
	public void findTask() {
		TaskService taskService = this.processEngine.getTaskService();
		List<Task>  taskList = taskService.createTaskQuery()
		                      .orderByTaskCreateTime()
		                      .desc()
		                      .list();
		if (null != taskList && taskList.size() > 0) {
			for (Task task : taskList) {
				log.info("【任务ID】: {}" , task.getId());
				log.info("【任务办理人】: {}" , task.getAssignee());
				log.info("【执行实例ID】: {}" , task.getExecutionId());
				log.info("【任务名称】: {}" , task.getName());
				log.info("【流程定义ID】: {}" , task.getProcessDefinitionId());
				log.info("【流程实例ID】: {}" , task.getProcessInstanceId());
				log.info("【任务创建时间】: {}" , task.getCreateTime());
				log.info("####################");
			}
		}
	}
	
	
	//完成任务
	@Test
	public void completeTask() {
		TaskService taskService = this.processEngine.getTaskService();
		String taskId = "2505";
		taskService.complete(taskId );
		log.info("任务完成");
	}
	
	
}
