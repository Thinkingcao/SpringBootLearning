package com.thinkingcao.springboot.exception.entity;

import lombok.Data;

import java.io.Serializable;

/**
 * @desc: 订单实体类
 * @author: cao_wencao
 * @date: 2019-12-05 14:22
 */
@Data
public class Order implements Serializable {
   
    private int orderId; //订单编号id
    private double orderMoney; //订单金额
    private String receiverAddress; //收货地址
    private String receiverName; //收货姓名
    private String receiverPhone; //手机号

}
