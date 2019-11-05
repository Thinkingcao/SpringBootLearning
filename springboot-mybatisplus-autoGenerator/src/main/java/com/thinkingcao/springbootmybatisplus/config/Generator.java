package com.thinkingcao.springbootmybatisplus.config;

import com.baomidou.mybatisplus.annotation.DbType;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.generator.AutoGenerator;
import com.baomidou.mybatisplus.generator.config.DataSourceConfig;
import com.baomidou.mybatisplus.generator.config.GlobalConfig;
import com.baomidou.mybatisplus.generator.config.PackageConfig;
import com.baomidou.mybatisplus.generator.config.StrategyConfig;
import com.baomidou.mybatisplus.generator.config.rules.NamingStrategy;

 /**
  * @desc: mybatis-plus代码自动生成:controller、service、serviceImpl、entity、mapper.xml
  * @auth: cao_wencao
  * @date: 2019/9/29 11:10
  */
public class Generator {
 
    public static void main(String[] args) {
        String packageName = "com.thinkingcao.springbootmybatisplus";
        boolean serviceNameStartWithI = false;//auth -> UserService, 设置成true: auth -> IUserService
        generateByTables(serviceNameStartWithI, packageName, "cao_wencao", "mybatis-plus", "t_student");
 
        System.out.println("completed...");
    }
 
    /**
     * @param serviceNameStartWithI
     * @param packageName   包名
     * @param author  作者
     * @param database  数据库名
     * @param tableNames 表名
     */
    private static void generateByTables(boolean serviceNameStartWithI, String packageName, String author, String database, String... tableNames) {
        GlobalConfig config = new GlobalConfig();
        String dbUrl = "jdbc:mysql://127.0.0.1:3306/" + database + "?useUnicode=true&characterEncoding=UTF-8&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
        DataSourceConfig dataSourceConfig = new DataSourceConfig();
        dataSourceConfig.setDbType(DbType.MYSQL)
                .setUrl(dbUrl)
                .setUsername("root")
                .setPassword("123456")
                .setDriverName("com.mysql.cj.jdbc.Driver");
        StrategyConfig strategyConfig = new StrategyConfig();
        strategyConfig
                .setCapitalMode(true)
                .setEntityLombokModel(false)
                .setNaming(NamingStrategy.underline_to_camel)
                .setInclude(tableNames);//修改替换成你需要的表名，多个表名传数组
        strategyConfig.setTablePrefix(new String[] { "t_"});// 此处可以修改为您的表前缀

        config.setActiveRecord(false)
                .setAuthor(author)
                .setOutputDir("F:\\IDEA_Project\\SpringBootLearning\\springboot-mybatisplus\\src\\main\\java")//生成文件路径就是你实际项目的路径
                .setFileOverride(true)
                .setBaseResultMap(true)//XML ResultMap
                .setEnableCache(false);//二级缓存
        if (!serviceNameStartWithI) {
            config.setServiceName("%sService")//%s为实体类名称后加services  还有其他文件得名称都可更改，这里我没有找到Entity修改的  待确定？
                   .setIdType(IdType.AUTO);//主键生成策略
        }
        new AutoGenerator().setGlobalConfig(config)
                .setDataSource(dataSourceConfig)
                .setStrategy(strategyConfig)
                .setPackageInfo(new PackageConfig()//设置包名
                                .setParent(packageName)
                                .setController("controller")
                                .setEntity("entity")
                                .setMapper("mapper")
                                .setService("service")
                                .setServiceImpl("service.impl")
                                .setXml("mapper")
                ).execute();
    }
 
}