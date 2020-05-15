package com.thinkingcao.encrypt.constant;

/**
 * @desc:
 * @author: cao_wencao
 * @date: 2020-05-14 19:15
 */
public class Constants {
    //固定盐APP_SECRET
    public static final String APP_SECRET = "30c722c6acc64306a88dd93a814c9f0a";

    //请求头token名称
    public static final String  USER_TOKEN = "user-token";
    //jwt密钥
    public static final String JWT_SECRET = "123456";
    //发行人
    public static final String JWT_ISSUER = "Thinkingcao";
    //JWT用户名
    public static final String JWT_USERNAME = "username";
    //观众
    public static final String JWT_AUDIENCE = "web";

    //默认JWT的过期时间12小时，单位：秒
    public static final long JWT_EXPIRE_SECOND = 12 * 60 * 60;

    //jwt 盐
    public static final String SALT = "1faf81180b4a4a78c48d7c31479a0622";
    // //默认redis中jwt的过期时间24小时，单位：秒
    public static final long TOKEN_EXPIRE_SECOND = 24* 60 * 60;
}
