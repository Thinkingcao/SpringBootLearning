package com.thinkingcao.springboot.activiti;

import org.activiti.engine.ProcessEngine;
import org.activiti.engine.ProcessEngineConfiguration;
import org.activiti.spring.boot.SecurityAutoConfiguration;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication(exclude = {SecurityAutoConfiguration.class})
public class SpringbootActivitiApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringbootActivitiApplication.class, args);
    }


    private static void initProcessGenerateTable(){
        // 引擎配置
        ProcessEngineConfiguration pec=ProcessEngineConfiguration.createStandaloneProcessEngineConfiguration();
        pec.setJdbcDriver("com.mysql.jdbc.Driver");
        pec.setJdbcUrl("jdbc:mysql://localhost:3306/springboot-activiti?useUnicode=true&characterEncoding=utf-8&useSSL=false&serverTimezone=UTC");
        pec.setJdbcUsername("root");
        pec.setJdbcPassword("123456");

        /**
         * false 不能自动创建表
         * create-drop 先删除表再创建表
         * true 自动创建和更新表
         */
        pec.setDatabaseSchemaUpdate(ProcessEngineConfiguration.DB_SCHEMA_UPDATE_TRUE);

        // 获取流程引擎对象
        ProcessEngine processEngine=pec.buildProcessEngine();
    }

}
