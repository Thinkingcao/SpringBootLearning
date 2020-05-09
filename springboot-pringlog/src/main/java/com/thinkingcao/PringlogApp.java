package com.thinkingcao;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.core.env.ConfigurableEnvironment;

@Slf4j
@SpringBootApplication
public class PringlogApp {

    public static void main(String[] args) {
        ConfigurableApplicationContext context = SpringApplication.run(PringlogApp.class, args);
         printLog(context);
        //loadBeans(context);
    }


    public static void loadBeans(ConfigurableApplicationContext context){
        String[] beanNames = context.getBeanDefinitionNames();
        //String[] beanNames = ctx.getBeanNamesForAnnotation(RestController.class);//所有添加该注解的bean
        log.info("bean总数:{}", context.getBeanDefinitionCount());
        int i = 0;
        for (String str : beanNames) {
            log.info("{},beanName:{}", ++i, str);
        }
    }

    public static void printLog(ConfigurableApplicationContext context){
        ConfigurableEnvironment environment = context.getEnvironment();
        String projectGroup = environment.getProperty("app.info.project-group");
        String projectName = environment.getProperty("app.info.project-name");
        String projectAuthor = environment.getProperty("app.info.project-author");
        String projectDescription = environment.getProperty("app.info.project-description");
        String sourceEncoding = environment.getProperty("app.info.project-sourceEncoding");
        String springbootVersion = environment.getProperty("app.info.project-springboot-version");
        String projectVersion = environment.getProperty("app.info.project-version");
        String projectContext = environment.getProperty("app.info.project-context");
        String blogUrl = environment.getProperty("app.info.blog-url");

        log.info("-------------- spring-demo project starting --------------");
        log.info("projectGroup : {}", projectGroup);
        log.info("projectContext : {}" , projectContext);
        log.info("projectName : {}", projectName);
        log.info("projectAuthor : {}", projectAuthor);
        log.info("projectDescription : {}", projectDescription);
        log.info("sourceEncoding : {}", sourceEncoding);
        log.info("springbootVersion : {}", springbootVersion);
        log.info("projectVersion : {}", projectVersion);
        log.info("blogUrl : {}", blogUrl);
        log.info("-------------- spring-demo project success --------------");
    }
}
