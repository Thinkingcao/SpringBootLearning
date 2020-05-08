package com.thinkingcao.config;// package com.thinkingcao.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * <pre>
 * @Description:  实现WebMvcConfigurer接口，自定义资源映射
 * @Aouth: cao_wencao
 * @Date: 2019-01-23 17:28
 * </pre>
 */
@Configuration
public class WebMvcConfig implements WebMvcConfigurer {


    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/images/**").addResourceLocations("file:D:/Images/壁纸/");
    }
}
