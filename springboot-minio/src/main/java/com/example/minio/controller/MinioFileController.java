package com.example.minio.controller;

import cn.hutool.core.date.DateUtil;
import com.example.minio.config.MinIoUtils;
import com.example.minio.result.RestResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;

/**
 * @desc: 文件上传工具类
 * @author: cao_wencao
 * @date: 2020-11-19 22:00
 */
@RestController
@Slf4j
public class MinioFileController {
    @Autowired
    private MinIoUtils minIoUtils;


    /**
     * 创建资源桶
     * @param bucketName
     * @return
     */
    @GetMapping(value = "/createBucket")
    public RestResponse createBucket(String bucketName){
        if (!minIoUtils.bucketExists(bucketName)) {
            minIoUtils.makeBucket(bucketName);
            return RestResponse.success("桶创建成功");
        }
        return RestResponse.fail("该桶已存在，请勿重复创建");
    }


    /**
     * @desc: 上传图片
     * @auth: cao_wencao
     * @date: 2020/11/19 22:22
     */
    @PostMapping(value = "uploadImg")
    public RestResponse uploadImage(@RequestParam("file") MultipartFile file) throws Exception {
        if (file.isEmpty()) {
            throw new RuntimeException("上传文件不能为空");
        } else {
            // 得到文件流
            final InputStream inputStream = file.getInputStream();
            // 文件名
            final String originalFilename = file.getOriginalFilename();
            String filelName = "bucketName" + "_" +
                    System.currentTimeMillis() +
                    "wechat.jpg".substring("wechat.jpg".lastIndexOf("."));

            String objectName = String.format("images/%s/%s", DateUtil.today(),+
                    System.currentTimeMillis() +
                    originalFilename.substring(originalFilename.lastIndexOf(".")));

            log.info("【objectName的名称】：{}", objectName);
            //String objectName = String.format("upload/images/%s/%s/%s", DateUtil.today(),
            //        UUID.randomUUID().toString().replace("-", "").substring(0, 10),
            //        originalFilename);
            // 把文件放到minio的boots桶里面
            minIoUtils.putObject(objectName, inputStream);
            // 关闭输入流
            inputStream.close();
            return RestResponse.success("上传成功");
        }
    }

    @RequestMapping("/getObjectURL")
    public RestResponse getObjectURL(String objectName){
        String url = minIoUtils.buildObjectUrl(objectName);
        return RestResponse.success(url);
    }

    /**
     * 删除文件
     * @param objectName
     * @return
     */
    @GetMapping(value = "removeImg")
    public RestResponse removeImage(@RequestParam("objectName") String objectName) {
        if (!StringUtils.hasText(objectName)){
            throw new RuntimeException("资源名称不能为空");
        }
        minIoUtils.removeObject(objectName);
        return RestResponse.success("删除成功");
    }


    /**
     * 下载文件到本地
     * @param objectName
     * @param response
     * @return
     * @throws Exception
     */
    @GetMapping("/downloadImage")
    public RestResponse downloadImage(@RequestParam("objectName") String objectName, HttpServletResponse response) throws Exception {
        ResponseEntity<byte[]> responseEntity = null;
        InputStream stream = null;
        ByteArrayOutputStream output = null;
        try {
            // 获取"myobject"的输入流。
            stream = minIoUtils.getObject(objectName);
            if (stream == null) {
                System.out.println("文件不存在");
            }
            //用于转换byte
            output = new ByteArrayOutputStream();
            byte[] buffer = new byte[4096];
            int n = 0;
            while (-1 != (n = stream.read(buffer))) {
                output.write(buffer, 0, n);
            }
            byte[] bytes = output.toByteArray();

            //设置header
            HttpHeaders httpHeaders = new HttpHeaders();
            httpHeaders.add("Accept-Ranges", "bytes");
            httpHeaders.add("Content-Length", bytes.length + "");
//            objectName = new String(objectName.getBytes("UTF-8"), "ISO8859-1");
            //把文件名按UTF-8取出并按ISO8859-1编码，保证弹出窗口中的文件名中文不乱码，中文不要太多，最多支持17个中文，因为header有150个字节限制。
            httpHeaders.add("Content-disposition", "attachment; filename=" + objectName);
            httpHeaders.add("Content-Type", "text/plain;charset=utf-8");
//            httpHeaders.add("Content-Type", "image/jpeg");
            responseEntity = new ResponseEntity<byte[]>(bytes, httpHeaders, HttpStatus.CREATED);

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (stream != null) {
                stream.close();
            }
            if (output != null) {
                output.close();
            }
        }
        return RestResponse.success(responseEntity);
    }


    /**
     * 在浏览器预览图片
     * @param objectName
     * @param response
     * @throws Exception
     */
    @RequestMapping("/preViewPicture/{objectName}")
    public void download1Image(@RequestParam("objectName") String objectName, HttpServletResponse response) throws Exception{
        response.setContentType("image/jpeg");
        ServletOutputStream out = null;
        try {
            out = response.getOutputStream();
            InputStream stream = minIoUtils.getObject(objectName);
            ByteArrayOutputStream output = new ByteArrayOutputStream();
            byte[] buffer = new byte[4096];
            int n = 0;
            while (-1 != (n = stream.read(buffer))) {
                output.write(buffer, 0, n);
            }
            byte[] bytes = output.toByteArray();
            out.write(bytes == null ? new byte[0]:bytes);
            out.flush();
        }finally {
            if (out != null) {
                out.close();
            }
        }
    }

}
