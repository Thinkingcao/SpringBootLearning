package com.thinkingcao.springboot.jackson.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Date;

/**
 * @desc:  订单实体类
 * @author: cao_wencao
 * @date: 2020-01-07 13:54
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class OrderEntity implements Serializable {

    private String orderId; //订单编号id

    private int goodId; //商品编号id

    private double orderMoney; //订单金额

    private String receiverName; //收货姓名

    private String receiverPhone; //手机号

    private String payState; //支付状态

    // @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
    private Date payDate; //支付时间
}
