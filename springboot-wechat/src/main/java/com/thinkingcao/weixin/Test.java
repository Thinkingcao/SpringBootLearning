package com.thinkingcao.weixin;

/**
 * @desc:
 * @author: cao_wencao
 * @date: 2020-05-21 16:17
 */
public class Test {

    public static void main(String[] args) {
        String result = getFileType("http://thinkingcao.viphk.ngrok.org:80/upload/image/201809/653bfa9e-8a52-452b-974f-85b6b8c29615.jpeg");
        System.out.println("result = " + result);
    }

    public static String getFileType(String url) {
        return url.substring(url.lastIndexOf(".") + 1);
    }
}
