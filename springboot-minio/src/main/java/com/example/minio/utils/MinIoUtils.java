package com.example.minio.utils;

import com.example.minio.properties.MinIoProperties;
import io.minio.MinioClient;
import io.minio.Result;
import io.minio.messages.Item;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import java.io.InputStream;

/**
 * http://docs.minio.org.cn/docs/master/java-client-api-reference
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

    public MinIoUtils(MinIoProperties minIoProperties) {
        if (!StringUtils.hasText(minIoProperties.getBucketName())) {
            throw new RuntimeException("bucket name can not be empty or null");
        }
        this.bucketName = StringUtils.trimTrailingCharacter(minIoProperties.getBucketName().trim(), '/');
        try {
            minioClient = new MinioClient(minIoProperties.getEndpoint(), minIoProperties.getAccessKey(), minIoProperties.getSecretKey());

        } catch (Throwable e) {
            throw new RuntimeException(e);
        }
    }


    /**
     * 判断bucket是否存在
     * @param bucketName
     * @return
     */
    public boolean bucketExists(String bucketName){
        try {
            return minioClient.bucketExists(bucketName);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    /**
     * 判断objec是否存在
     * @param objectName
     * @return
     */
    public boolean objectExists(String objectName){
        boolean isExists = false;
        try {
            InputStream inputStream = minioClient.getObject(bucketName, objectName);
            if (null != inputStream){
                isExists = true;
            }
            return isExists;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * 获取object
     * @param objectName
     * @return
     */
    public InputStream getObject(String objectName) throws Exception {
        return minioClient.getObject(bucketName, objectName);
    }

    /**
     * 获取object集合
     * @param  bucketN
     * @return
     */
    public Iterable<Result<Item>> listObjects(String bucketN){
        if (StringUtils.hasText(bucketN)){
            bucketN = bucketName;
        }
        try {
            return minioClient.listObjects(bucketN);
        } catch (Throwable e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * 根据prefix获取object集合
     * @param prefix
     * @return
     */
    public Iterable<Result<Item>> listObjectsByPrefix(String prefix) {
        try {
            return minioClient.listObjects(bucketName, prefix);
        } catch (Throwable e) {
            throw new RuntimeException(e);
        }
    }


    /**
     * 创建bucket
     * @param bucketName
     */
    public void makeBucket(String bucketName){
        try {
            boolean isExist = minioClient.bucketExists(bucketName);
            if(!isExist) {
                minioClient.makeBucket(bucketName);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * 上传文件
     * @param bucketName
     * @param objectName
     * @param filename
     */
    public void putObject(String bucketName, String objectName, String filename){
        try {
            minioClient.putObject(bucketName,objectName,filename,null);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * 上传文件
     * @param objectName
     * @param filename
     */
    public void putObject(String objectName, String filename){
        try {
            minioClient.putObject(bucketName,objectName,filename,null);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * 上传文件-InputStream
     * @param bucketName
     * @param objectName
     * @param stream
     */
    public void putObject(String bucketName, String objectName, InputStream stream){
        try {
            minioClient.putObject(bucketName,objectName,stream,null);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * 上传文件-InputStream
     * @param objectName
     * @param stream
     */
    public void putObject(String objectName, InputStream stream){
        try {
            minioClient.putObject(bucketName,objectName,stream,null);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * 删除文件
     * @param bucketName
     * @param objectName
     */
    public void removeObject(String bucketName, String objectName){
        try {
            minioClient.removeObject(bucketName,objectName);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * 删除文件
     * @param objectName
     */
    public void removeObject(String objectName){
        try {
            minioClient.removeObject(bucketName,objectName);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
