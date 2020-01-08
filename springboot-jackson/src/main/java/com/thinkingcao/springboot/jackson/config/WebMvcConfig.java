package com.thinkingcao.springboot.jackson.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * @desc:
 * @author: cao_wencao
 * @date: 2020-01-08 17:30
 */
@Configuration
@EnableWebMvc
public class WebMvcConfig implements WebMvcConfigurer {


    // @Override
    // public void configureMessageConverters(List<HttpMessageConverter<?>> converters) {
    //     // 1.需要先定义一个convert 转换消息的对象
    //     FastJsonHttpMessageConverter fastConverter = new FastJsonHttpMessageConverter();
    //     // 2.添加fastJson的配置信息,比如，是否需要格式化返回的json数据
    //     FastJsonConfig fastJsonConfig = new FastJsonConfig();
    //     // 空值特别处理
    //     // WriteNullListAsEmpty 将Collection类型字段的字段空值输出为[]
    //     // WriteNullStringAsEmpty 将字符串类型字段的空值输出为空字符串 ""
    //     // WriteNullNumberAsZero 将数值类型字段的空值输出为0
    //     // WriteNullBooleanAsFalse 将Boolean类型字段的空值输出为false
    //     fastJsonConfig.setSerializerFeatures(
    //             SerializerFeature.PrettyFormat,
    //             SerializerFeature.WriteNullListAsEmpty,
    //             SerializerFeature.WriteNullStringAsEmpty);
    //     // 处理中文乱码问题
    //     List<MediaType> fastMediaTypes = new ArrayList<>();
    //     fastMediaTypes.add(MediaType.APPLICATION_JSON_UTF8);
    //     fastConverter.setSupportedMediaTypes(fastMediaTypes);
    //     fastJsonConfig.setDateFormat("yyyy/MM/dd HH:mm:ss");
    //     // 3.在convert中添加配置信息
    //     fastConverter.setFastJsonConfig(fastJsonConfig);
    //     // 4.将convert添加到converters当中
    //     converters.add(fastConverter);
    // }
}
