package com.thinkingcao.config;// package com.thinkingcao.config;
//
// import org.springframework.context.annotation.Configuration;
// import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
// import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
//
// /**
//  * <pre>
//  * @Description: 继承WebMvcConfigurerAdapter类，配置静态资源映射(已过时)
//  * @Aouth: cao_wencao
//  * @Date: 2019-01-23 16:11
//  * </pre>
//  */
// @Configuration
// public class WebMvcConfiguration extends WebMvcConfigurerAdapter {
//     @Override
//     public void addResourceHandlers(ResourceHandlerRegistry registry) {
//         //addResourceHandler是指你想在url请求的路径
//         //addResourceLocations是图片存放的真实路径
//         registry.addResourceHandler("/images/**").addResourceLocations("file:D://Images//壁纸/");
//         super.addResourceHandlers(registry);
//     }
//
// }
