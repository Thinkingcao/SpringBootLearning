package com.example.springboot.config;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.annotation.Resource;
import javax.sql.DataSource;

/**
 * @desc:  Mybatis第一个数据源的配置
 * @author: cao_wencao
 * @date: 2020-11-13 15:48
 */
@Configuration
@MapperScan(basePackages = "com.example.springboot.mapper1", sqlSessionFactoryRef = "sqlSessionFactoryMaster",sqlSessionTemplateRef = "sqlSessionTemplateMaster")
public class MybatisMasterConfig {

    //private static String mapperLocation = "classpath*:mapper/**/*MapperTwo.xml";

    @Resource
    private DataSource dsMaster;

    @Bean(name = "sqlSessionFactoryMaster")
    public SqlSessionFactory sqlSessionFactoryMaster() throws Exception {
        SqlSessionFactoryBean factoryBean = new SqlSessionFactoryBean();
        factoryBean.setDataSource(dsMaster); // 使用master数据源, 连接master库
        //factoryBean.setMapperLocations(new PathMatchingResourcePatternResolver().getResources(mapperLocation));
        return factoryBean.getObject();
    }

    @Bean(name = "sqlSessionTemplateMaster")
    public SqlSessionTemplate sqlSessionTemplateMaster() throws Exception {
        SqlSessionTemplate template = new SqlSessionTemplate(sqlSessionFactoryMaster()); // 使用上面配置的Factory
        return template;
    }

}
