package com.thinkingcao.config;//
// package com.thinkingcao.config;
//
// import org.springframework.context.annotation.Configuration;
// import org.springframework.web.servlet.config.annotation.CorsRegistry;
// import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
// import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;
//
// /**
//  * <pre>
//  * @Description: 继承WebMvcConfigurationSupport类，实现自定义资源映射
//  * @Aouth: cao_wencao
//  * @Date: 2019-01-23 17:39
//  * </pre>
//  */
//
// @Configuration
// public class WebConfig extends WebMvcConfigurationSupport {
//
//
//     /**
//      * 跨域支持
//      *
//      * @param registry
//      */
//     @Override
//     public void addCorsMappings(CorsRegistry registry) {
//         registry.addMapping("/**")
//                 .allowedOrigins("*")
//                 .allowCredentials(true)
//                 .allowedMethods("GET", "POST", "DELETE", "PUT")
//                 .maxAge(3600 * 24);
//     }
//
//
//     /**
//      * 添加静态资源--过滤swagger-api (开源的在线API文档)
//      *
//      * @param registry
//      */
//
//     @Override
//     public void addResourceHandlers(ResourceHandlerRegistry registry) {
//         registry.addResourceHandler("/images/**")
//                 .addResourceLocations("file:D:/Images/壁纸/");
//         //过滤swagger
//         registry.addResourceHandler("swagger-ui.html")
//                 .addResourceLocations("classpath:/META-INF/resources/");
//
//         registry.addResourceHandler("/webjars/**")
//                 .addResourceLocations("classpath:/META-INF/resources/webjars/");
//
//         registry.addResourceHandler("/swagger-resources/**")
//                 .addResourceLocations("classpath:/META-INF/resources/swagger-resources/");
//
//         registry.addResourceHandler("/swagger/**")
//                 .addResourceLocations("classpath:/META-INF/resources/swagger*");
//
//         registry.addResourceHandler("/v2/api-docs/**")
//                 .addResourceLocations("classpath:/META-INF/resources/v2/api-docs/");
//
//     }
//
//
//
//
// }
//
