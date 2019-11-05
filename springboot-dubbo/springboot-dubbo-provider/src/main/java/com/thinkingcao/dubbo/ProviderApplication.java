package com.thinkingcao.dubbo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import com.alibaba.dubbo.spring.boot.annotation.EnableDubboConfiguration;

/**
 * <pre>
 * dubbo服务提供者启动类
 * &#64;author cao_wencao
 * &#64;date 2018年12月20日 下午5:39:45
 * </pre>
 */
@SpringBootApplication
@EnableDubboConfiguration
public class ProviderApplication {
	public static void main(String[] args) {
		SpringApplication.run(ProviderApplication.class, args);
	}
}
