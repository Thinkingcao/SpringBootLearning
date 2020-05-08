package com.thinkingcao.springboot.activiti.init;
import org.activiti.engine.ProcessEngine;
import org.activiti.engine.ProcessEngineConfiguration;
import org.activiti.engine.ProcessEngines;
import org.activiti.engine.RepositoryService;
import org.junit.Test;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

/**
 * @desc: 执行main方法即可生成表
 * @author: cao_wencao
 * @date: 2020-01-09 13:48
 */
public class InitTable {
    public static void main(String[] args) {
    	
    	// 创建数据源
    	DriverManagerDataSource dataSource = new DriverManagerDataSource();
    	dataSource.setDriverClassName("com.mysql.jdbc.Driver");
    	dataSource.setUrl("jdbc:mysql://127.0.0.1:3306/springboot-activiti?characterEncoding=UTF-8");
    	dataSource.setUsername("root");
    	dataSource.setPassword("123456");
    	
        // 流程引擎配置
        ProcessEngineConfiguration pec =ProcessEngineConfiguration.createStandaloneProcessEngineConfiguration();
        pec.setDataSource(dataSource);

        /**
         * create-drop 创建表，使用完后删除
         * false 不能自动创建表
         * create-drop 先删除表再创建表(初始化)
         * true 自动创建和更新表
         */
        pec.setDatabaseSchemaUpdate("drop-create");

        // 初始化获取流程引擎对象
        ProcessEngine processEngine=pec.buildProcessEngine();
        System.out.println("【初始化流程引擎对象processEngine】："+ processEngine);
    }
    
  
}
