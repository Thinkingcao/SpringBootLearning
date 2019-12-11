package com.thinkingcao.springboot.ehcache.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;

/**
 * @desc: Order实体类
 * @author: cao_wencao
 * @date: 2019-12-05 14:22
 */
@Entity
@Table(name = "t_order")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Order implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int orderId; //订单编号id

    private int goodId; //商品编号id

    private double orderMoney; //订单金额

    private String receiverAddress; //收货地址

    private String receiverName; //收货姓名

    private String receiverPhone; //手机号

}
