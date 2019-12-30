package com.thinkingcao.springboot.qrcode.controller;

import com.thinkingcao.springboot.qrcode.utils.QrCodeUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.util.ResourceUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;

/**
 * @desc: 生成二维码REST API接口
 * @author: cao_wencao
 * @date: 2019-12-26 23:05
 */
@Slf4j
@RestController
@RequestMapping("/qrCode")
public class QrCodeController {


    /**
     * @url:  http://127.0.0.1:8080/qrCode/getCommonQRCode?url=https://blog.csdn.net/thinkingcao
     * @desc: 生成普通二维码
     * @auth: cao_wencao
     * @date: 2019/12/30 16:01
     */
    @GetMapping(value = "/getCommonQRCode")
    public void getCommonQRCode(HttpServletResponse response, String url) throws Exception {
        ServletOutputStream stream = null;
        try {
            stream = response.getOutputStream();
            //使用工具类生成不带logo二维码
            QrCodeUtil.encode(url, stream);
        } finally {
            //关闭流操作
            if (stream != null) {
                stream.flush();
                stream.close();
            }
        }
    }

    /**
     * @url : http://127.0.0.1:8080/qrCode/getQRCodeWithLogo?url=https://blog.csdn.net/thinkingcao
     * @desc: 生成 带有logo二维码
     * @auth: cao_wencao
     * @date: 2019/12/30 16:02
     */
    @GetMapping(value = "/getQRCodeWithLogo")
    public void getQRCodeWithLogo(HttpServletResponse response, String url) throws Exception {
        ServletOutputStream stream = null;
        try {
            stream = response.getOutputStream();
            String path = ResourceUtils.getURL("classpath:").getPath();
            log.debug("项目logo资源classpath ： {}", path);
            //logo图片地址
            String  logoPath= ResourceUtils.getURL("classpath:").getPath()+"static/images/"+"logo.jpg";
            log.debug("logo完整url地址：{}", logoPath);
            //使用工具类生成带logo二维码
            QrCodeUtil.encode(url, logoPath, stream, true);
        } finally {
            //关闭流操作
            if (stream != null) {
                stream.flush();
                stream.close();
            }
        }
    }
}
