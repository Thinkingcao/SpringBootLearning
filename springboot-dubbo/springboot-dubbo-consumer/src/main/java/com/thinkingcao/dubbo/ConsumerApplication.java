package com.thinkingcao.dubbo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.alibaba.dubbo.spring.boot.annotation.EnableDubboConfiguration;

/**
 * <pre>
 *  
 * dubbo服务消费者启动类
 * &#64;author cao_wencao
 * &#64;date 2018年12月20日 下午5:45:23
 * </pre>
 */
@SpringBootApplication
@EnableDubboConfiguration
public class ConsumerApplication {

	public static void main(String[] args) {
		SpringApplication.run(ConsumerApplication.class, args);
	}
}
