package com.thinkingcao.weixin.controller;

import com.alibaba.fastjson.JSON;
import com.thinkingcao.weixin.manage.WeChatMaterialUtils;
import com.thinkingcao.weixin.result.ApiResult;
import lombok.extern.slf4j.Slf4j;
import me.chanjar.weixin.mp.api.WxMpService;
import me.chanjar.weixin.mp.bean.material.WxMpMaterialUploadResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

/**
 * @desc:
 * @author: cao_wencao
 * @date: 2020-05-21 13:47
 */
@Slf4j
@RestController
@RequestMapping("/wx/material")
public class WxMaterialController {

    @Autowired
    private WxMpService wxMpService;

    @Autowired
    private WeChatMaterialUtils materialUtils;

    /**
     * 上传单个图片文件
     */
    @PostMapping("/uploadImg")
    public ApiResult uploadImg(@RequestParam("imgFile") MultipartFile imgFile) throws IOException {
        log.info("multipartFile = " + imgFile);
        log.info("ContentType = " + imgFile.getContentType());
        log.info("OriginalFilename = " + imgFile.getOriginalFilename());
        log.info("Name = " + imgFile.getName());
        log.info("Size = " + imgFile.getSize());
        String fileExt = imgFile.getOriginalFilename().substring(imgFile.getOriginalFilename().lastIndexOf(".") + 1);
        log.info("fileExt = " + fileExt);

        WxMpMaterialUploadResult wxMpMaterialUploadResult
                 = materialUtils.uploadFilesToWeChat("image", fileExt ,imgFile.getName(), imgFile.getInputStream());
        if(null == wxMpMaterialUploadResult){
            return ApiResult.error("上传图片失败");
        }
        log.info("wxMpMaterialUploadResult = : " + JSON.toJSONString(wxMpMaterialUploadResult));
        return ApiResult.succee(wxMpMaterialUploadResult,"上传图片成功");
    }
}
