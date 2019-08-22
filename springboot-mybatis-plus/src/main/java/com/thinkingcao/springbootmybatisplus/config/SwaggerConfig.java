package com.thinkingcao.springbootmybatisplus.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * <pre>
 * @desc: Swagger接口配置
 * @author: cao_wencao
 * @date: 2019-08-21 17:33
 * @version: 1.0
 * </pre>
 */
@EnableSwagger2
@Configuration
public class SwaggerConfig {

    @Bean
    public Docket createRestApi() {
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiInfo())
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.thinkingcao.springbootmybatisplus.controller"))
                .paths(PathSelectors.any())
                .build();
    }

    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                .title("MyBatis-Plus 3.x Demo")
                .description("Spring Boot基础MyBatis-Plus 3.0.1 实现 student-city-idCard 示例")
                .termsOfServiceUrl("https://thinkingcao.blog.csdn.net/")
                .contact(new Contact("Thinkingcao", "https://thinkingcao.blog.csdn.net/", "thinkingcao@163.com"))
                .version("1.0")
                .license("license")
                .licenseUrl("https://thinkingcao.blog.csdn.net/")
                .build();
    }

}
