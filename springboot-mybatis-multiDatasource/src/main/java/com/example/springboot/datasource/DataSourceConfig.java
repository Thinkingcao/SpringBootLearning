package com.example.springboot.datasource;

import com.alibaba.druid.spring.boot.autoconfigure.DruidDataSourceBuilder;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

import javax.sql.DataSource;

/**
 * @desc: 多数据源配置，提供两个DataSource
 * @author: cao_wencao
 * @date: 2020-11-13 15:27
 */
@Configuration
public class DataSourceConfig {

    /**
     * 主数据源
     * @Primary 注解声明为默认数据源
     * @return
     */
    @Primary
    @Qualifier("master")
    @Bean(name = "master")
    @ConfigurationProperties(prefix = "spring.datasource.master")
    public DataSource masterDatasource() {
        return DruidDataSourceBuilder.create().build();
    }

    /**
     * 从数据源
     * @return
     */
    @Bean(name = "slave")
    @Qualifier("slave")
    @ConfigurationProperties(prefix = "spring.datasource.slave")
    @ConditionalOnProperty(prefix = "spring.datasource.slave", name = "enabled", havingValue = "true")
    public DataSource slaveDatasource() {
        return DruidDataSourceBuilder.create().build();
    }
}
