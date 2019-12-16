package com.thinkingcao.springboot.token.utils;

import sun.misc.BASE64Decoder;
import sun.misc.BASE64Encoder;

import java.io.UnsupportedEncodingException;

@SuppressWarnings("restriction")
public class Base64Utils {
	// 加密
	public static String encodeByBase64(String str) {
		byte[] b = null;
		String s = null;
		try {
			b = str.getBytes("utf-8");
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		if (b != null) {
			s = new BASE64Encoder().encode(b);
		}
		return s;
	}

	// 解密
	public static String decodeByBase64(String s) {
		byte[] b = null;
		String result = null;
		if (s != null) {
			BASE64Decoder decoder = new BASE64Decoder();
			try {
				b = decoder.decodeBuffer(s);
				result = new String(b, "utf-8");
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return result;
	}
	
	public static void main(String[] args) {
		String str1 = "ershuai\"\" /   < > &  \\?？【】；‘、1，。、,;";
		System.out.println("原始数据："+str1);
		System.out.println("加密数据："+encodeByBase64(str1));
		String str2 = "ZXJzaHVhaSIiIC8gICA8ID4gJiAgP++8n+OAkOOAke+8m+KAmOOAgTHvvIzjgILjgIEsOw==";
		System.out.println("解密数据："+decodeByBase64(str2));
	}	
}
