package com.thinkingcao.springbootfreemarker.config;

import lombok.Data;
import lombok.ToString;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

//表示这个类是一个读取配置文件的类
@Configuration
//指定配置的一些属性,其中的prefix表示前缀
@ConfigurationProperties(prefix = "info.thinkingcao")
//指定所读取的配置文件的路径
@PropertySource(value = "classpath:resource.properties")
@Data
@ToString
public class ResourceProperties{
    private String author;
    private String blog;
    private String language;
}
