package com.thinkingcao.thymeleaf3.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.LocaleResolver;

/**
 * @desc:
 * @author: cao_wencao
 * @date: 2020-08-19 14:12
 */
@Configuration
public class WebMvcConfig {
    @Bean
    public LocaleResolver localeResolver() {
        return  new MyLocaleResolver();
    }
}
