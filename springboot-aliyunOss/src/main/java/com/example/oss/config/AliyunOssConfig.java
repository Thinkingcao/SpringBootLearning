package com.example.oss.config;

import com.aliyun.oss.OSS;
import com.aliyun.oss.OSSClient;
import lombok.Data;
import lombok.experimental.Accessors;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.io.Serializable;

/**
 * @desc: 阿里云OSS参数配置
 * @author: cao_wencao
 * @date: 2020-11-06 15:02
 */
//声明配置类，注入Spring容器
@Configuration
//指定读取的配置文件位置
//@PropertySource(value = {"classpath:application.yml"})
//指定配置文件中自定义属性前缀
@ConfigurationProperties(prefix = "aliyun")
@Data
@Accessors(chain = true)//开启链式调用
public class AliyunOssConfig implements Serializable {
    // 地域节点
    private String endPoint;
    // accessKeyId
    private String accessKeyId;
    // accessKeySecret
    private String accessKeySecret;
    // OSS的Bucket名称
    private String bucketName;
    // Bucket 域名
    private String urlPrefix;
    // 目标文件夹
    private String fileHost;

    //将OSS 客户端交给Spring容器托管
    @Bean
    public OSS OSSClient() {
        return new OSSClient(endPoint, accessKeyId, accessKeySecret);
    }
}
