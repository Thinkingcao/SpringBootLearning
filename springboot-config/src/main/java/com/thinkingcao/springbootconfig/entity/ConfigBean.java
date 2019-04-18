package com.thinkingcao.springbootconfig.entity;

import lombok.Data;
import lombok.ToString;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * <pre>
 * @Description:
 * @Aouth: cao_wencao
 * @Date: 2019-02-19 14:52
 * </pre>
 */
@Data
@ToString
@ConfigurationProperties(prefix = "my")
@Component
public class ConfigBean {
    private String name;
    private int age;
    private int number;
    private String uuid;
    private int max;
    private String value;
    private String greeting;
}
