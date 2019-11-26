package com.thinkingcao.springbootswagger.config;

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
 * @Description: swagger2的配置文件，这里可以配置swagger2的一些基本的内容，比如扫描的包等等
 * @Aouth: cao_wencao
 * @Date: 2019-02-19 16:13
 * </pre>
 */
@Configuration
@EnableSwagger2
public class SwaggerConfig {

    @Bean
    public Docket createRestApi() {
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiInfo())
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.thinkingcao.springbootswagger.controller"))
                .paths(PathSelectors.any())
                .build();
    }
    //构建 api文档的详细信息函数,注意这里的注解引用的是哪个
    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                .title("SpringBoot利用Swagger-Bootstrap-Ui构建RESTful APIs文档")      //页面标题
                .description("Swagger-Bootstrap-Ui简单优雅的restfun风格")           //描述
                .termsOfServiceUrl("https://blog.csdn.net/thinkingcao")
                .contact(new Contact("Thinkingcao", "https://thinkingcao.blog.csdn.net/", "Thinkingcao@163.com"))
                .version("1.0") //版本号
                .build();
    }
}
