package com.thinkingcao.springboot.aop.utils;

import sun.misc.BASE64Encoder;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.UUID;

/**
 * @desc: token工具类
 * @auth: cao_wencao
 * @date: 2019/12/16 13:54
 */
public class TokenUtils {
	private static final String MEMBER_TOKEN = "member_token";
 
	 //token生成
	 public synchronized static String getToken() {
		String tokenStr =  UUID.randomUUID().toString().replace("-", "");;
		 BASE64Encoder base64 = new BASE64Encoder();
		 String  token = base64.encode(tokenStr.getBytes());
		 return token;
	 }


	public static void main(String[] args) throws NoSuchAlgorithmException {
		for (int i = 0; i < 100; i++) {
			//System.out.println(UUID.randomUUID().toString().replace("-", ""));
			System.out.println(TokenUtils.getToken());
		}
	}
}
