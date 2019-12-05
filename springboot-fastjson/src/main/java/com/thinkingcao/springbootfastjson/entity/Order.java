package com.thinkingcao.springbootfastjson.entity;

import com.alibaba.fastjson.annotation.JSONField;
import lombok.Data;

import java.util.Date;

/**
 * @desc: Order实体类
 * @author: cao_wencao
 * @date: 2019-12-05 14:22
 */
@Data
public class Order {

    private int orderId; //订单编号id

    private int goodId; //商品编号id

    private double orderMoney; //订单金额

    private String receiverAddress; //收货地址

    private String receiverName; //收货姓名

    @JSONField(serialize = false) //转换为json时不包括该属性
    private String receiverPhone; //手机号

    private String payState; //支付状态

    @JSONField(format = "yyyy-MM-dd HH:mm:ss") //格式化日期
    private Date payDate; //支付时间
}
