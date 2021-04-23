package com.thinkingcao.springboot.orika.config;

import ma.glasnost.orika.MapperFacade;
import ma.glasnost.orika.MapperFactory;
import ma.glasnost.orika.impl.DefaultMapperFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
* @Description: orkia配置
* @author: thinkingcao
* @Date: 2021/04/23 22:56:26
*
*/
@Configuration
public class OrikaConfig {

    @Bean
    public MapperFactory mapperFactory(){
        return new DefaultMapperFactory.Builder().build();
    }

    @Bean
    public MapperFacade mapperFacade(){
        return mapperFactory().getMapperFacade();
    }
}
