package com.thinkingcao.springbootfastjson.config;

/**
 * @desc: 自定义消息转换器为FastJson
 * @author: cao_wencao
 * @date: 2019-12-05 14:15
 */
// @Configuration
// public class FastJsonMvcConfig{
//
//     @Bean
//     public HttpMessageConverters fastJsonHttpMessageConverters() {
//         //1、定义一个convert转换消息的对象
//         FastJsonHttpMessageConverter fastConverter = new FastJsonHttpMessageConverter();
//         //2、添加fastjson的配置信息
//         FastJsonConfig fastJsonConfig = new FastJsonConfig();
//         fastJsonConfig.setSerializerFeatures(SerializerFeature.PrettyFormat);
//         //3、在convert中添加配置信息
//         fastConverter.setFastJsonConfig(fastJsonConfig);
//         //4、将convert添加到converters中
//         HttpMessageConverter<?> converter = fastConverter;
//         return new HttpMessageConverters(converter);
//     }
// }
