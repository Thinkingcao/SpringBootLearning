package com.example.minio.properties;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

/**
 * @desc:
 * @author: cao_wencao
 * @date: 2020-11-19 17:13
 */
@Data
@Configuration
@ConfigurationProperties(prefix = "minio")
public class MinIoProperties {
    /**
     * 服务地址
     */
    private String endpoint;
    /**
     * 用户名
     */
    private String accessKey;
    /**
     * 密码
     */
    private String secretKey;
    /**
     * 桶名称
     */
    private String bucketName;
}
