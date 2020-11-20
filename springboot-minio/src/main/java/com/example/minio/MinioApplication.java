package com.example.minio;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class MinioApplication {

    public static void main(String[] args) {
        SpringApplication.run(MinioApplication.class, args);
       /*
        String filelName = "bucketName" + "_" +
                System.currentTimeMillis() +
                "wechat.jpg".substring("wechat.jpg".lastIndexOf("."));

        System.out.println("filelName = " + filelName);


        String format = String.format("upload/images/%s/%s/%s", DateUtil.today(),
                IdUtil.randomUUID().substring(0, 10),
                "wechat.jpg");

        System.out.println("format = " + format);*/
    }

}
