package com.thinkingcao.springbootmapstruct.entity;

import lombok.Data;

import javax.persistence.*;

/**
 * <pre>
 * @desc:订单表 d
 * @author: cao_wencao
 * @date: 2019-11-04 22:36
 * @version: 1.0
 * </pre>
 */
@Entity
@Table(name="t_order")
@Data
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "order_id" ,columnDefinition = "int(100) COMMENT '订单编号id'")
    
    private int orderId;
    @Column(name = "good_id",columnDefinition = "int(100) COMMENT '商品编号id'")
    private int goodId;

    @Column(name = "order_money" ,columnDefinition = "int(100) COMMENT '订单金额'")
    private double orderMoney;

    @Column(name = "receiver_address",columnDefinition = "varchar(255) COMMENT '收货地址'")
    private String receiverAddress;

    @Column(name = "receiver_name",columnDefinition = "varchar(100) COMMENT '收货姓名'")
    private String receiverName;

    @Column(name = "receiver_phone",columnDefinition = "varchar(100) COMMENT '手机号'")
    private String receiverPhone;

    @Column(name = "pay_state",columnDefinition = "int(100) COMMENT '支付状态'")
    private int payState;

  

   

}
