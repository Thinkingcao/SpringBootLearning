package com.example.springboot.config;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;

import javax.sql.DataSource;

/**
 * @desc:
 * @author: cao_wencao
 * @date: 2020-11-13 15:49
 */
@Configuration
@MapperScan(basePackages = "com.example.springboot.mapper2", sqlSessionFactoryRef = "sqlSessionFactory2",sqlSessionTemplateRef = "sqlSessionTemplate2")
public class MybatisSlaveConfig {

    private static String mapperLocation = "classpath*:mapper/**/*Mapper*.xml";

    @Autowired
    @Qualifier("slave")
    private DataSource dsMaster;

    @Bean(name = "sqlSessionFactory2")
    public SqlSessionFactory sqlSessionFactory2() throws Exception {
        SqlSessionFactoryBean factoryBean = new SqlSessionFactoryBean();
        factoryBean.setDataSource(dsMaster); // 使用master数据源, 连接master库
        factoryBean.setMapperLocations(new PathMatchingResourcePatternResolver().getResources(mapperLocation));
        return factoryBean.getObject();
    }

    @Bean(name="sqlSessionTemplate2")
    public SqlSessionTemplate sqlSessionTemplate2() throws Exception {
        SqlSessionTemplate template = new SqlSessionTemplate(sqlSessionFactory2()); // 使用上面配置的Factory
        return template;
    }

}
