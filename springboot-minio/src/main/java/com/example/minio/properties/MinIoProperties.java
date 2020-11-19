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
    private String endpoint;
    private String accessKey;
    private String secretKey;
    private String bucketName;
}
