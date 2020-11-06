package com.example.oss.controller;

import com.example.oss.config.AliyunOssConfig;
import com.example.oss.result.RestResponse;
import com.example.oss.service.OssFileUploadService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;

/**
 * @desc:
 * @author: cao_wencao
 * @date: 2020-11-06 15:22
 */
@Api(tags = "阿里云OSS文件上传、下载、删除API")
@RequestMapping("api/oss/")
@RestController
public class OssFileController {
    @Autowired
    private OssFileUploadService fileUploadService;

    @Autowired
    private AliyunOssConfig aliyunOssConfig;

    /**
     * 阿里云文件上传API
     *
     * @param file
     * @return
     */
    @ApiOperation(value = "文件上传")
    @PostMapping("upload")
    public RestResponse upload(@RequestParam("file") MultipartFile file) {
        if (file != null) {
            String returnFileUrl = fileUploadService.upload(file);
            if (returnFileUrl.equals("error")) {
                return RestResponse.error("文件上传失败！");
            }
            return RestResponse.succee(returnFileUrl,"文件上传成功！");
        } else {
            return RestResponse.error("文件上传失败！");
        }
    }

    /**
     * 阿里云文件下载API
     *
     * @param fileName
     * @param response
     * @return
     * @throws Exception
     */
    @ApiOperation(value = "文件下载")
    @GetMapping(value = "download/{fileName}")
    public RestResponse download(@PathVariable("fileName") String fileName, HttpServletResponse response) throws Exception {

        String status = fileUploadService.download(fileName, response);
        if (status.equals("error")) {
            return RestResponse.error("文件下载失败！");
        }
        return RestResponse.succee("文件下载成功！");

    }

    /**
     * 阿里云文件删除API
     *
     * @param fileName
     * @return
     */
    @ApiOperation(value = "文件删除")
    @GetMapping("/delete/{fileName}")
    public RestResponse DeleteFile(@PathVariable("fileName") String fileName) {
        String status = fileUploadService.delete(fileName);
        if (status.equals("error")) {
            return RestResponse.error("文件删除失败！");
        } else {
            return RestResponse.succee("文件删除成功！");
        }
    }

}
