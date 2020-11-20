package com.example.minio.config;

import com.example.minio.properties.MinIoProperties;
import io.minio.MinioClient;
import io.minio.PutObjectOptions;
import io.minio.Result;
import io.minio.messages.Bucket;
import io.minio.messages.Item;
import lombok.SneakyThrows;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import java.io.InputStream;
import java.util.List;

/**
 * http://docs.minio.org.cn/docs/master/java-client-api-reference
 * 参考：https://www.jianshu.com/p/7f493105b2b2
 *
 * @desc: 构建MinIo工具类
 * @author: cao_wencao
 * @date: 2020-11-19 17:16
 */
@Component
@EnableConfigurationProperties(value = {MinIoProperties.class})
@ConditionalOnProperty(prefix = "minio", name = {"endpoint", "accessKey", "secretKey", "bucketName"})
public class MinIoUtils {

    private final MinioClient minioClient;

    private final String bucketName;


    @Autowired
    private MinIoProperties minIoProperties;

    /**
     * 初始化MinioClient
     */
    @SneakyThrows
    public MinIoUtils(MinIoProperties minIoProperties) {
        if (!StringUtils.hasText(minIoProperties.getBucketName())) {
            throw new RuntimeException("bucket name can not be empty or null");
        }
        this.bucketName = StringUtils.trimTrailingCharacter(minIoProperties.getBucketName().trim(), '/');

        minioClient = new MinioClient(minIoProperties.getEndpoint(), minIoProperties.getAccessKey(), minIoProperties.getSecretKey());


    }


    /**
     * 判断bucket是否存在
     *
     * @param bucketName bucket名称
     * @return
     */
    @SneakyThrows
    public boolean bucketExists(String bucketName) {
        return minioClient.bucketExists(bucketName);
    }

    /**
     * 创建bucket
     *
     * @param bucketName bucket名称
     */
    @SneakyThrows
    public void makeBucket(String bucketName) {
        boolean isExist = minioClient.bucketExists(bucketName);
        if (!isExist) {
            minioClient.makeBucket(bucketName);
        }
    }

    /**
     * 获取全部bucket
     */
    @SneakyThrows
    public List<Bucket> getAllBuckets() {
        return minioClient.listBuckets();
    }

    /**
     * 判断文件是否存在
     *
     * @param objectName 文件名称
     * @return
     */
    public boolean objectExists(String objectName) {
        boolean isExists = false;
        try {
            InputStream inputStream = minioClient.getObject(bucketName, objectName);
            if (null != inputStream) {
                isExists = true;
            }
            return isExists;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * 获取单个文件
     *
     * @param objectName 文件名称
     * @return
     */
    @SneakyThrows
    public InputStream getObject(String objectName) {
        return minioClient.getObject(bucketName, objectName);
    }

    /**
     * 获取文件集合
     *
     * @param bucketN bucket名称
     * @return
     */
    @SneakyThrows
    public Iterable<Result<Item>> listObjects(String bucketN) {
        if (StringUtils.hasText(bucketN)) {
            bucketN = bucketName;
        }
        return minioClient.listObjects(bucketN);
    }


    /**
     * 根据prefix获取object集合
     *
     * @param prefix
     * @return
     */
    @SneakyThrows
    public Iterable<Result<Item>> listObjectsByPrefix(String prefix) {
        return minioClient.listObjects(bucketName, prefix);
    }

    /**
     * 获取文件外链
     *
     * @param objectName 文件名称
     * @return
     */
    @SneakyThrows
    public String buildObjectUrl(String objectName) {
        if (!StringUtils.hasText(objectName)) {
            throw new RuntimeException("object name can not be empty or null");
        }

        objectName = StringUtils.trimLeadingCharacter(StringUtils.trimTrailingCharacter(objectName.trim(), '/'), '/');

        String objectUrl = String.format("%s/%s", bucketName, objectName);
        if (StringUtils.hasText(minIoProperties.getEndpoint())) {
            objectUrl = String.format("%s/%s", minIoProperties.getEndpoint(), objectUrl);
        }
        return objectUrl;
    }


    /**
     * 上传文件-InputStream
     *
     * @param bucketName bucket名称
     * @param objectName 文件名称
     * @param stream     文件流
     */
    @SneakyThrows
    public void putObject(String bucketName, String objectName, InputStream stream) {
        minioClient.putObject(bucketName, objectName, stream, new PutObjectOptions(stream.available(), -1));
    }

    /**
     * 上传文件-InputStream
     *
     * @param objectName 文件名称
     * @param stream     文件流
     */
    @SneakyThrows
    public void putObject(String objectName, InputStream stream) {
        minioClient.putObject(bucketName, objectName, stream, new PutObjectOptions(stream.available(), -1));
    }

    /**
     * 上传文件
     *
     * @param objectName  文件名称
     * @param stream      文件流
     * @param size        大小
     * @param contentType 类型
     * @return the object url string
     */
    @SneakyThrows
    public String putObject(String objectName, InputStream stream, Long size, String contentType) {

        if (!StringUtils.hasText(objectName)) {
            throw new RuntimeException("object name can not be empty or null");
        }
        minioClient.putObject(bucketName, objectName, stream, new PutObjectOptions(stream.available(), -1));
        return buildObjectUrl(objectName);
    }


    /**
     * 删除文件
     *
     * @param bucketName bucket名称
     * @param objectName 文件名称
     */
    @SneakyThrows
    public void removeObject(String bucketName, String objectName) {
        minioClient.removeObject(bucketName, objectName);
    }

    /**
     * 删除文件
     *
     * @param objectName 文件名称
     */
    @SneakyThrows
    public void removeObject(String objectName) {
        minioClient.removeObject(bucketName, objectName);
    }

}
