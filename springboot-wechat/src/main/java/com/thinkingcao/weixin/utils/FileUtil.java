package com.thinkingcao.weixin.utils;

/**
 * @desc:
 * @author: cao_wencao
 * @date: 2020-05-21 16:19
 */
public class FileUtil {
    public static String getFileType(String url) {
        return url.substring(url.lastIndexOf(".") + 1);
    }
}
