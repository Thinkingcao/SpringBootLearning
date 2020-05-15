package com.thinkingcao.encrypt.common;

import lombok.Data;

import java.io.Serializable;

/**
 * @desc:  完整的报文请求体: 请求体、请求体、Sign签名
 * @author: cao_wencao
 * @date: 2020-05-15 11:57
 */
@Data
public class RequestMessage implements Serializable {
    private static final long serialVersionUID = 4266591985812284174L;
    private HeadRequest head;// 请求头
    private Object body;// 请求内容
    private String sign;// 签名
}
