package com.thinkingcao.springbootfastjson.config;

import com.alibaba.fastjson.serializer.SerializeConfig;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.alibaba.fastjson.serializer.ToStringSerializer;
import com.alibaba.fastjson.support.config.FastJsonConfig;
import com.alibaba.fastjson.support.spring.FastJsonHttpMessageConverter;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.math.BigInteger;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.List;

/**
 * @desc: 自定义消息转换器为FastJson
 * @author: cao_wencao
 * @date: 2019-12-05 14:59
 */
@Configuration
public class FastJsonConfiguration implements WebMvcConfigurer {

    @Override
    public void extendMessageConverters(List<HttpMessageConverter<?>> converters) {

        //1、定义一个convert转换消息的对象
        FastJsonHttpMessageConverter converter = new FastJsonHttpMessageConverter();

        //2.定义支持的mediaType类型，处理中文乱码相关问题
        List<MediaType> mediaTypes = new ArrayList<>();
        mediaTypes.add(MediaType.APPLICATION_JSON); //返回JSON格式
        mediaTypes.add(MediaType.APPLICATION_JSON_UTF8); //处理输出中文乱码
        mediaTypes.add(MediaType.TEXT_HTML);
        mediaTypes.add(new MediaType("application", "xml"));
        mediaTypes.add(new MediaType("text", "xml"));
        mediaTypes.add(new MediaType("application", "*+xml"));
        mediaTypes.add(MediaType.ALL);
        converter.setSupportedMediaTypes(mediaTypes);

        //3.创建配置类
        FastJsonConfig fastJsonConfig = new FastJsonConfig();
        fastJsonConfig.setCharset(Charset.forName("UTF-8")); //全局编码
        fastJsonConfig.setDateFormat("yyyy-MM-dd HH:mm:ss"); //全局时间格式化

        //4.修改返回内容过滤
        SerializerFeature[] serializerFeatures = new SerializerFeature[]{
                SerializerFeature.PrettyFormat,                 // 格式化
                SerializerFeature.WriteMapNullValue,            // 输出空值
                SerializerFeature.WriteNullListAsEmpty,         // List字段如果为null,输出为[],而非null
                SerializerFeature.WriteDateUseDateFormat,       // 日期格式化
                SerializerFeature.WriteNullStringAsEmpty,     //字符类型字段如果为null,输出为"",而非null
                SerializerFeature.WriteNullBooleanAsFalse,    //Boolean字段如果为null,输出为false,而非null
                SerializerFeature.DisableCircularReferenceDetect, //消除对同一对象循环引用的问题，默认为false（如果不配置有可能会进入死循环）
                SerializerFeature.WriteNullNumberAsZero    //数字类型如果为null,输出为0，而非null
        };
        fastJsonConfig.setSerializerFeatures(serializerFeatures);

        //5.配置Java类型对应的序列化类，long变成string，解决Long转json精度丢失的问题
        SerializeConfig serializeConfig = SerializeConfig.globalInstance;
        serializeConfig.put(BigInteger.class, ToStringSerializer.instance);
        serializeConfig.put(Long.class, ToStringSerializer.instance);
        serializeConfig.put(Long.TYPE, ToStringSerializer.instance);
        fastJsonConfig.setSerializeConfig(serializeConfig);

        converter.setFastJsonConfig(fastJsonConfig);

        converters.add(0,converter);

    }

}
