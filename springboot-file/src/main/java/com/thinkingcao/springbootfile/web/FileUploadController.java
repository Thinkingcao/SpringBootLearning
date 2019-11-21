package com.thinkingcao.springbootfile.web;

import com.google.common.collect.Maps;
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
import java.util.Map;

/**
 * @desc: 文件上传Controller
 * @author: cao_wencao
 * @date: 2019-11-21 16:41
 */
@Controller
@Slf4j
public class FileUploadController {


    /**
     * 默认大小 50M
     */
    public static final long DEFAULT_MAX_SIZE = 50 * 1024 * 1024;

    @Value("${file.path}")
    private String uploadPath;

    @RequestMapping("/singleFile")
    public String singleFile() {
        return "singleFileUpload";
    }


    /**
     * @desc: 单文件上传
     * @auth: cao_wencao
     * @date: 2019/11/21 17:01
     */
    @PostMapping("/singleFileUpload")
    @ResponseBody
    public Object singleFileUpload(@RequestParam("file") MultipartFile file) throws IOException {

        // 获取文件在服务器上的存储位置
        String serverPath = globalProperties.getServerPath();

        // 获取允许上传的文件扩展名
        String extension = globalProperties.getExtension();

        File filePath = new File(serverPath);
        logger.info("文件保存的路径为：" + filePath);
        if (!filePath.exists() && !filePath.isDirectory()) {
            logger.info("目录不存在，则创建目录：" + filePath);
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
        log.info("将文件保存到指定目录");
        if (!newfile.exists() && !newfile.isDirectory()) {
            log.info("目录不存在，则创建目录：" + newfile);
            newfile.mkdir();
        }
        file.transferTo(newfile);
        return ResponseCode.success("上传成功");

    }


    /**
     * @desc: 多文件上传
     * @auth: cao_wencao
     * @date: 2019/11/21 17:01
     */
    @PostMapping("/multiFileupload")
    public Object multiFileupload(MultipartFile[] files) throws IOException {
        Map<String, Object> resultMap = Maps.newHashMap();
        int                 length    = files.length;
        for (int i = 0; i < length; i++) {
            log.info("【上传的文件名为】： [{}]", files[i].getOriginalFilename());
            log.info("【上传的文件大小为】：[{}]", files[i].getSize());
            log.info("【上传的文件类型为：】： [{}]", files[i].getContentType());
            File newfile = new File(uploadPath + files[i].getOriginalFilename());
            if (!newfile.exists() && !newfile.isDirectory()) {
                log.info("目录不存在，则创建目录：" + newfile);
                newfile.mkdir();
            }
            files[i].transferTo(newfile);
        }
        resultMap.put("code", 200);
        resultMap.put("message", "上传成功");
        return resultMap;
    }


}
