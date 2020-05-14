package com.thinkingcao.encrypt.utils;

import java.util.UUID;

/**
 * @desc:
 * @author: cao_wencao
 * @date: 2020-05-09 18:38
 */
public class UUIDUtil {
    public static String getUuid(){
        String uuid = UUID.randomUUID().toString().replaceAll("-", "");
        return uuid;
    }

    public static void main(String[] args) {
        System.out.println(getUuid());
    }
}
