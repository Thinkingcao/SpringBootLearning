package com.thinkingcao.encrypt.common;

import lombok.Data;

/**
 * @desc: 请求头公共请求参数
 * @author: cao_wencao
 * @date: 2020-05-14 17:18
 */
@Data
public class HeadRequest {
    /**
     * appId
     */
    private String appId;

    /**
     * appSecret秘钥
     */
    private String appSecret;

    /**
     * 10位时间戳
     */
    private String timestamp;

    /**
     * 参数签名
     */
    private String sign;

    /**
     * 随机字符串
     */
    private String nonce;

    /**
     * api版本号
     */
    private String version = "1.0";

}
