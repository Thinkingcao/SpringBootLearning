package com.thinkingcao.springbootfile.web;

import com.thinkingcao.springbootfile.result.ResponseCode;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;

/**
 * @desc: 文件上传Controller
 * @author: cao_wencao
 * @date: 2019-11-21 16:41
 */
@Controller
@Slf4j
@RequestMapping("/upload/")
public class FileUploadController {

    /**
     * 默认大小 50M
     */
    public static final long DEFAULT_MAX_SIZE = 50 * 1024 * 1024;

    //文件上传路径(磁盘目录)
    @Value("${spring.servlet.multipart.location}")
    private String uploadPath;


    //单文件上传页面
    @RequestMapping("/singleFile")
    public String singleFile() {
        return "singleFileUpload";
    }

    //多文件上传页面
    @RequestMapping("/multiFile")
    public String multiFileupload() {
        return "multiFileupload";
    }


    /**
     * @desc: 单文件上传
     * @auth: cao_wencao
     * @date: 2019/11/21 17:01
     */
    @PostMapping("/singleFileUpload")
    @ResponseBody
    public Object singleFileUpload(@RequestParam("file") MultipartFile file) throws IOException {
        File filePath = new File(uploadPath);
        log.info("【文件保存的路径为】： {}", filePath);
        if (!filePath.exists() && !filePath.isDirectory()) {
            log.info("【目录不存在，则创建目录】：{}", filePath);
            filePath.mkdir();
        }
        // 判断文件是否为空
        if (file.isEmpty()) {
            return ResponseCode.error("文件为空");
        }
        //判断文件是否为空文件
        if (file.getSize() <= 0) {
            return ResponseCode.error("文件大小为空，上传失败");
        }
        // 判断文件大小不能大于50MB
        if (DEFAULT_MAX_SIZE != -1 && file.getSize() > DEFAULT_MAX_SIZE) {
            return ResponseCode.error("上传的文件不能大于50M");
        }
        // 获取文件名
        String fileName = file.getOriginalFilename();
        // 获取文件扩展名
        String fileExtension = fileName.substring(fileName.lastIndexOf(".")).toLowerCase();
        // 重新生成的文件名
        String saveFileName = System.currentTimeMillis() + fileExtension;
        log.info("【上传的文件名为】： [{}]", fileName);
        log.info("【上传的文件大小为】：[{}]", file.getSize());
        log.info("【上传的文件类型为：】： [{}]", file.getContentType());
        // 在指定目录下创建该文件
        File newfile = new File(uploadPath, saveFileName);
        log.info("【将文件保存到指定目录】： [{}]", filePath);
        file.transferTo(newfile);
        return ResponseCode.success("上传成功");

    }


    /**
     * @desc: 多文件上传, 多文件上传就是单文件上传的list遍历
     * @auth: cao_wencao
     * @date: 2019/11/21 17:01
     */
    @PostMapping("/multiFileUpload")
    @ResponseBody
    public Object multiFileupload(@RequestParam("files") MultipartFile[] files) throws IOException {
        if (null == files) {
            return ResponseCode.error("参数为空");
        }
        File filePath = new File(uploadPath);
        log.info("【文件保存的路径为】： {}", filePath);
        if (!filePath.exists() && !filePath.isDirectory()) {
            log.info("【目录不存在，则创建目录】：{}", filePath);
            filePath.mkdir();
        }
        for (MultipartFile multipartFile : files) {
            if (multipartFile.isEmpty()) {
                return ResponseCode.error("文件为空");
            }
            //判断文件是否为空文件
            if (multipartFile.getSize() <= 0) {
                return ResponseCode.error("文件大小为空，上传失败");
            }
            // 判断文件大小不能大于50MB
            if (DEFAULT_MAX_SIZE != -1 && multipartFile.getSize() > DEFAULT_MAX_SIZE) {
                return ResponseCode.error("上传的文件不能大于50M");
            }
            // 获取文件名
            String fileName = multipartFile.getOriginalFilename();
            // 获取文件扩展名
            String fileExtension = fileName.substring(fileName.lastIndexOf(".")).toLowerCase();
            // 重新生成的文件名
            String saveFileName = System.currentTimeMillis() + fileExtension;
            log.info("【上传的文件名为】： [{}]", fileName);
            log.info("【上传的文件大小为】：[{}]", multipartFile.getSize());
            log.info("【上传的文件类型为：】： [{}]", multipartFile.getContentType());
            // 在指定目录下创建该文件
            File newfile = new File(uploadPath, saveFileName);
            log.info("【将文件保存到指定目录】： [{}]", filePath);
            multipartFile.transferTo(newfile);
        }
        return ResponseCode.success("批量上传成功");
    }


}
