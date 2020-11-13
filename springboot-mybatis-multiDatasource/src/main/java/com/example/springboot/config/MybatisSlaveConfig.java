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
 * @desc:
 * @author: cao_wencao
 * @date: 2020-11-13 15:49
 */
@Configuration
@MapperScan(basePackages = "com.example.springboot.mapper2", sqlSessionFactoryRef = "sqlSessionFactorySlave",sqlSessionTemplateRef = "sqlSessionTemplateSlave")
public class MybatisSlaveConfig {

    //private static String mapperLocation = "classpath*:mapper/**/*MapperOne.xml";

    @Resource
    private DataSource dsMaster;

    @Bean(name = "sqlSessionFactorySlave")
    public SqlSessionFactory sqlSessionFactorySlave() throws Exception {
        SqlSessionFactoryBean factoryBean = new SqlSessionFactoryBean();
        factoryBean.setDataSource(dsMaster); // 使用master数据源, 连接master库
        //factoryBean.setMapperLocations(new PathMatchingResourcePatternResolver().getResources(mapperLocation));
        return factoryBean.getObject();
    }

    @Bean(name="sqlSessionTemplateSlave")
    public SqlSessionTemplate sqlSessionTemplateSlave() throws Exception {
        SqlSessionTemplate template = new SqlSessionTemplate(sqlSessionFactorySlave()); // 使用上面配置的Factory
        return template;
    }

}
