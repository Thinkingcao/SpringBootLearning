package com.example.oss.config;

import com.github.xiaoymin.knife4j.spring.annotations.EnableKnife4j;
import com.google.common.base.Predicates;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import springfox.bean.validators.configuration.BeanValidatorPluginsConfiguration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * @desc:  swagger2文档基本参数配置
 * @author: cao_wencao
 * @date: 2020-11-06 15:07
 */
@Configuration
@EnableSwagger2// 开启swagger2
@EnableKnife4j
@Import(BeanValidatorPluginsConfiguration.class)
public class Knife4jConfig {

    @Value("${swagger.isShow:false}")
    private boolean isShow;

    @Bean
    public Docket webApiConfig() {

        return new Docket(DocumentationType.SWAGGER_2)
                .enable(isShow) //配置swagger是否开启显示，测试环境开启，生产环境关闭
                .groupName("Knife4j2.X版本")
                .apiInfo(webApiInfo())
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.example"))
                .paths(Predicates.not(PathSelectors.regex("/error.*")))
                .build();
    }

    private ApiInfo webApiInfo() {
        return new ApiInfoBuilder()
                .title("SpringBoot整合阿里云OSS实现文件上传，下载，删除功能")
                .description("使用 knife4j 搭建的后台服务API接口文档")
                .termsOfServiceUrl("http://127.0.0.1:8080/doc.html")
                .version("1.0")
                .contact(new Contact("Thinkingcao", "https://thinkingcao.blog.csdn.net/", "Thinkingcao@163.com"))
                .build();
    }

}
