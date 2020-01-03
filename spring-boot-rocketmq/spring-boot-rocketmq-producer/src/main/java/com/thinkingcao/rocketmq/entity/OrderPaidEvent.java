package com.thinkingcao.rocketmq.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * <pre>
 * @desc: 订单信息实体类
 * @auth: cao_wencao
 * @date: 2019/6/10 15:58
 * @param null
 * </pre>
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class OrderPaidEvent implements Serializable {

    private String orderId; //订单id编号

    private Integer paidMoney; //订单金额
}