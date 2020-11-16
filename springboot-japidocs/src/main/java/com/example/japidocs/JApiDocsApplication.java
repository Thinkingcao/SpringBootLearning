package com.example.japidocs;

import io.github.yedaxia.apidocs.Docs;
import io.github.yedaxia.apidocs.DocsConfig;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * 启动类
 */
@SpringBootApplication
@MapperScan(basePackages = {"com.example.japidocs.**.mapper"})//扫描mybatis的所有**Mapper接口文件
public class JApiDocsApplication {

    public static void main(String[] args) {
        SpringApplication.run(JApiDocsApplication.class, args);
        generateApiDocs();
    }


    private static void generateApiDocs(){
        DocsConfig config = new DocsConfig();
        config.setProjectPath("F:\\IDEA_Project\\SpringBootLearning\\springboot-japidocs"); // 项目根目录
        config.setProjectName("springboot-japidocs"); // 项目名称
        config.setApiVersion("V1.0");       // 声明该API的版本
        config.setDocsPath("F:\\IDEA_Project\\SpringBootLearning\\springboot-japidocs\\apidocs"); // 生成API 文档所在目录
        config.setAutoGenerate(Boolean.TRUE);  // 配置自动生成
        Docs.buildHtmlDocs(config); // 执行生成文档
    }
}
