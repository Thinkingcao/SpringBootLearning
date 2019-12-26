package com.thinkingcao.springboot.qrcode.controller;

import com.thinkingcao.springboot.qrcode.utils.QrCodeUtil;
import org.springframework.util.ResourceUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import java.io.File;

/**
 * @desc:
 * @author: cao_wencao
 * @date: 2019-12-26 23:05
 */
@RestController
@RequestMapping("/qrCode")
public class QrCodeController {

    /**
     * 生成 普通二维码
     */
    @GetMapping(value = "/getCommonQRCode")
    public void getCommonQRCode(HttpServletResponse response, String url) throws Exception {
        ServletOutputStream stream = null;
        try {
            stream = response.getOutputStream();
            //使用工具类生成二维码
            QrCodeUtil.encode(url, stream);
        } finally {
            if (stream != null) {
                stream.flush();
                stream.close();
            }
        }
    }

    /**
     * 生成 带有logo二维码
     */
    @GetMapping(value = "/getQRCodeWithLogo")
    public void getQRCodeWithLogo(HttpServletResponse response, String url) throws Exception {
        ServletOutputStream stream = null;
        try {
            stream = response.getOutputStream();
            // logo 地址
            String logoPath = Thread.currentThread().getContextClassLoader().getResource("").getPath()
                    + "templates" + File.separator + "logo.jpg";
            // String logoPath = "springboot-demo-list/qr-code/src/main/resources/templates/logo.jpg";
            //使用工具类生成二维码
            QrCodeUtil.encode(url, logoPath, stream, true);
        } finally {
            if (stream != null) {
                stream.flush();
                stream.close();
            }
        }
    }
}
