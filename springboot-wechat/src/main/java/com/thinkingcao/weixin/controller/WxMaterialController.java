package com.thinkingcao.weixin.controller;

import com.alibaba.fastjson.JSON;
import com.thinkingcao.weixin.manage.WeChatMaterialUtils;
import com.thinkingcao.weixin.result.ApiResult;
import lombok.extern.slf4j.Slf4j;
import me.chanjar.weixin.mp.bean.material.WxMpMaterialNews;
import me.chanjar.weixin.mp.bean.material.WxMpMaterialUploadResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @desc:
 * @author: cao_wencao
 * @date: 2020-05-21 13:47
 */
@Slf4j
@RestController
@RequestMapping("/wx/material")
public class WxMaterialController {

   private static final SimpleDateFormat sdf =new SimpleDateFormat("yyyy-MM-dd HH:mm:ss SSS" );

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


    /**
     * 上传图文素材文件
     */
    @PostMapping("/uploadNewsToWeChat")
    public ApiResult uploadNewsToWeChat(@RequestParam("imgFile") MultipartFile imgFile) throws IOException {
        log.info("multipartFile = " + imgFile);
        log.info("ContentType = " + imgFile.getContentType());
        log.info("OriginalFilename = " + imgFile.getOriginalFilename());
        log.info("Name = " + imgFile.getName());
        log.info("Size = " + imgFile.getSize());
        String fileExt = imgFile.getOriginalFilename().substring(imgFile.getOriginalFilename().lastIndexOf(".") + 1);
        log.info("fileExt = " + fileExt);

        WxMpMaterialUploadResult wxMpMaterialUploadResult
                = materialUtils.uploadFilesToWeChat("image", fileExt ,imgFile.getName(), imgFile.getInputStream());

        List<WxMpMaterialNews.WxMpMaterialNewsArticle> articlesList = new ArrayList();
        WxMpMaterialNews.WxMpMaterialNewsArticle article = new WxMpMaterialNews.WxMpMaterialNewsArticle();
        article.setAuthor("Thinkingcao");
        article.setContent("SpringBoot 系列教程(九十八)：SpringBoot+WxJava开发微信公众号之回复图文消息");
        article.setContentSourceUrl("www.baidu.com");
        article.setDigest("SpringBoot+WxJava开发微信公众号之回复图文消息");
        article.setNeedOpenComment(true);
        article.setOnlyFansCanComment(true);
        article.setShowCoverPic(true);
        article.setThumbMediaId(wxMpMaterialUploadResult.getMediaId());
        article.setThumbUrl("");
        article.setTitle("SpringBoot 系列教程(九十八)：SpringBoot+WxJava开发微信公众号之回复图文消息");
        article.setUrl(wxMpMaterialUploadResult.getUrl());
        articlesList.add(article);

        WxMpMaterialNews  materialNews = new WxMpMaterialNews();
        materialNews.setArticles(articlesList);
        materialNews.setCreateTime(new Date());
        materialNews.setUpdateTime(new Date());

        WxMpMaterialUploadResult wxMpMaterialUploadResult1 = materialUtils.uploadNewsToWeChat(materialNews);
        log.info("wxMpMaterialUploadResult1 =" + wxMpMaterialUploadResult1);
        return ApiResult.succee(wxMpMaterialUploadResult1,"上传图文素材成功");
    }

}
