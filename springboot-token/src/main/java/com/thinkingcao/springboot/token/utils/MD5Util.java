package com.thinkingcao.springboot.token.utils;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;


/**
 * @desc: MD5加密工具类
 * @auth: cao_wencao
 * @date: 2019/12/16 13:51
 */
public class MD5Util {

    /**
     * MD5 加密   绿账的加密方式
     *绿账加密方式，仅适用绿账
     * @param plainText 明文
     * @return 消息摘要
     * @throws NoSuchAlgorithmException
     */
    public static String encode(String plainText) {
        if (plainText == null || "".equals(plainText)) {
            return null;
        }
        MessageDigest md = null;
        try {
            md = MessageDigest.getInstance("MD5");
            md.update(plainText.getBytes("UTF-8"));
            byte b[] = md.digest();
            int i;
            StringBuffer buf = new StringBuffer("");
            for (int offset = 0; offset < b.length; offset++) {
                i = b[offset];
                if (i < 0)
                    i += 256;
                if (i < 16)
                    buf.append("0");
                buf.append(Integer.toHexString(i));
            }
            return buf.toString();
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        } catch (UnsupportedEncodingException e) {

            // TODO Auto-generated catch block
            e.printStackTrace();

        }
        return plainText;
    }

    /**
     * MD5 加密
     *两网加密方式
     * @param inStr 明文
     * @return
     * @throws NoSuchAlgorithmException
     */
    public static String md5(String inStr) {
            MessageDigest md5;
            try {
                md5 = MessageDigest.getInstance("MD5");
            } catch (Exception e) {
                e.printStackTrace();
                return "";
            }
            char[] charArray = inStr.toCharArray();
            byte[] byteArray = new byte[charArray.length];

            for (int i = 0; i < charArray.length; i++)
                byteArray[i] = (byte) charArray[i];
            byte[] md5Bytes = md5.digest(byteArray);
            StringBuffer hexValue = new StringBuffer();
            for (int i = 0; i < md5Bytes.length; i++) {
                int val = ((int) md5Bytes[i]) & 0xff;
                if (val < 16)
                    hexValue.append("0");
                hexValue.append(Integer.toHexString(val));
            }
            return hexValue.toString();
    }

    public static void main(String[] args) {
        System.out.println("原密码：533626");
        System.out.println("md5+hex之后密码为：" + encode("533626"));
        System.out.println("再base64编码之后为：" + Base64Utils.encodeByBase64(encode("533626")));
    }

}
