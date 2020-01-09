package com.thinkingcao.springboot.activiti;

/**
 * @desc: 执行main方法即可生成表
 * @author: cao_wencao
 * @date: 2020-01-09 13:48
 */
public class app {
   /* public static void main(String[] args) {
        // 引擎配置
        ProcessEngineConfiguration pec=ProcessEngineConfiguration.createStandaloneProcessEngineConfiguration();
        pec.setJdbcDriver("com.mysql.jdbc.Driver");
        pec.setJdbcUrl("jdbc:mysql://localhost:3306/springboot-activiti?useUnicode=true&characterEncoding=utf-8&useSSL=false&serverTimezone=UTC");
        pec.setJdbcUsername("root");
        pec.setJdbcPassword("123456");

        *//**
         * false 不能自动创建表
         * create-drop 先删除表再创建表
         * true 自动创建和更新表
         *//*
        pec.setDatabaseSchemaUpdate(ProcessEngineConfiguration.DB_SCHEMA_UPDATE_TRUE);

        // 获取流程引擎对象
        ProcessEngine processEngine=pec.buildProcessEngine();
    }*/
}
