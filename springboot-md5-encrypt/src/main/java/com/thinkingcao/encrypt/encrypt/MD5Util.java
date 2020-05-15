package com.thinkingcao.encrypt.encrypt;

import org.apache.commons.codec.digest.DigestUtils;

/**
 * @desc: 基于apache.commons.codec封装摘要运算、编码解码工具类
 * @auth: cao_wencao
 * @date: 2020-05-09 17:59
 */
public class MD5Util {
    
    /**
     * 加密方法
     * @param str
     * @return
     */
    public static String md5(String str) {
        return DigestUtils.md5Hex(str);
    }

    //固定盐
    private static final String salt = "30c722c6acc64306a88dd93a814c9f0a";
    
    /**
     * 将用户输入的明文密码与固定盐进行拼装后再进行MD5加密
     * @param inputPass
     * @return
     */
    public static String inputPassToFormPass(String inputPass) {
        String str = ""+salt.charAt(0)+salt.charAt(2) + inputPass +salt.charAt(5) + salt.charAt(4);
        System.out.println(str);
        return md5(str);
    }
    
    /**
     * 将form表单中的密码转换成数据库中存储的密码
     * @param formPass
     * @param salt 随机盐
     * @return
     */
    public static String formPassToDBPass(String formPass, String salt) {
        String str = ""+salt.charAt(0)+salt.charAt(2) + formPass +salt.charAt(5) + salt.charAt(4);
        return md5(str);
    }
    
    public static String inputPassToDbPass(String inputPass, String saltDB) {
        String formPass = inputPassToFormPass(inputPass);
        String dbPass = formPassToDBPass(formPass, saltDB);
        return dbPass;
    }
    
}