package com.thinkingcao.springbootxml.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;

/**
 * @desc: 加载application-context.xml配置文件
 * @author: cao_wencao
 * @date: 2019-12-06 20:13
 */
@Configuration
@ImportResource(locations={"classpath:application-context.xml"})
public class OrderConfig {
}
