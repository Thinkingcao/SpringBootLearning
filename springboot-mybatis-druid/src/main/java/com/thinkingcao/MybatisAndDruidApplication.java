package com.thinkingcao;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * <pre>
 * @author cao_wencao
 * @date 2018年12月4日 下午1:59:57
 * </pre>
 */
@SpringBootApplication
@MapperScan("com.thinkingcao.modules.mapper")
public class MybatisAndDruidApplication {

	/**
	 * <pre>  
	 * @author cao_wencao
	 * @param args
	 * </pre>  
	 */
	public static void main(String[] args) {
		SpringApplication.run(MybatisAndDruidApplication.class, args);

	}

}
