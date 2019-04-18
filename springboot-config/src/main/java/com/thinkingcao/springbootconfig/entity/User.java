package com.thinkingcao.springbootconfig.entity;

import lombok.Data;
import lombok.ToString;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

/**
 * <pre>
 * @Description:
 * @Aouth: cao_wencao
 * @Date: 2019-02-19 15:17
 * </pre>
 */
@Data
@ToString
@Configuration
@PropertySource(value = "classpath:test.properties")
@ConfigurationProperties(prefix = "com.thinkingcao")
public class User {
    private String name;
    private int age;
}
