package com.thinkingcao.encrypt;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

// 1. @ServletComponentScan: Servlet、Filter、Listener可以直接通过@WebServlet、@WebFilter、@WebListener注解自动注册。
// 2. 使用了ServletListenerRegistrationBean注册Bean就不需要使用@ServletComponentScan扫描了
// @ServletComponentScan
@SpringBootApplication
public class SpringBootMd5EncryptApp {

    public static void main(String[] args) {
        SpringApplication.run(SpringBootMd5EncryptApp.class, args);
    }

}
