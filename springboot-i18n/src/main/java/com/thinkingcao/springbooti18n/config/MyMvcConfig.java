package com.thinkingcao.springbooti18n.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * 使用WebMvcConfigurerAdapter可以扩展SpringMvc的功能，包括拦截器，转换器等@EnableWebMvc //设置@EnableWebMvc为完全接管SpringMvc，但一般不要设置完全接管SpringMvc
 * @desc: 实现WebMvcConfigurer接口，支持国际化i18n
 * @auth: cao_wencao
 * @date: 2019/8/27 18:08
 */
@Configuration
public class MyMvcConfig implements WebMvcConfigurer {

    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        //设置对“/”的请求映射到login
        //如果没有数据返回到页面，没有必要用控制器方法对请求进行映射
        registry.addViewController("/").setViewName("login");
    }


    /**
     * @desc: 注册我们自定义的区域解析器，一旦将我们的区域解析器注册到Spring容器中则SpingBoot默认提供的区域解析器将不会自动注册
     * @auth: cao_wencao
     * @date: 2019/8/28 13:59
     */
    @Bean
    public LocaleResolver localeResolver() {
        return new I18nLocaleResolver();
    }

}
