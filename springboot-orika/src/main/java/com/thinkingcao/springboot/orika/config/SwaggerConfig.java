package com.thinkingcao.springboot.orika.config;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;


/**
 * @desc: swagger自动配置类
 * @author: cao_wencao
 * @date: 2021-03-24 15:54
 */
@Slf4j
@EnableSwagger2
@AllArgsConstructor
@Configuration
@Profile({"dev","test","uat","pro"})  //通过spring.active激活某个环境
public class SwaggerConfig implements WebMvcConfigurer {

    @Bean
    public Docket apiConfig() {
        return new Docket(DocumentationType.SWAGGER_2)
                .enable(true)
                .apiInfo(apiInfo())
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.thinkingcao.springboot.orika.controller"))
                .paths(PathSelectors.any())
                .build();
    }

    //构建api文档的详细信息
    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                .title("SpringBoot 系列教程(一百零八)：SpringBoot整合Orika实体映射工具")      //页面标题
                .description("restful风格的API接口")  //描述
                .termsOfServiceUrl("https://thinkingcao.blog.csdn.net/") //url
                .version("1.0") //版本号
                .build();
    }

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler(new String[]{"/static/**"}).addResourceLocations(new String[]{"classpath:/static/"});
        registry.addResourceHandler(new String[]{"swagger-ui.html"}).addResourceLocations(new String[]{"classpath:/META-INF/resources/"});
        registry.addResourceHandler(new String[]{"/webjars/**"}).addResourceLocations(new String[]{"classpath:/META-INF/resources/webjars/"});
    }
}
