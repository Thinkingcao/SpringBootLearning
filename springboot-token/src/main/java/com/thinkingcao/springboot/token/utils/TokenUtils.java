package com.thinkingcao.springboot.token.utils;

import java.util.UUID;

/**
 * @desc: token工具类
 * @auth: cao_wencao
 * @date: 2019/12/16 13:54
 */
public class TokenUtils {
	private static final String MEMBER_TOKEN = "member_token";
 
	 //token生成
	 public static String getToken(){
		 return MEMBER_TOKEN + UUID.randomUUID();
	 }
	
	
}
