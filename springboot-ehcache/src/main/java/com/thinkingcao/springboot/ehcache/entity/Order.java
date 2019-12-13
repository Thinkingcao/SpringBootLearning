package com.thinkingcao.springboot.ehcache.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;

/**
 * JPA提供的四种标准用法为TABLE，SEQUENCE，IDENTITY，AUTO。
 * a，TABLE：使用一个特定的数据库表格来保存主键。
 * b，SEQUENCE：通过序列产生主键，通过@SequenceGenerator 注解指定序列名，MySql不支持这种方式
 * c，IDENTITY：主键由数据库id自增（主要是自动增长型）
 * d，AUTO：主键由程序控制。是默认选项
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
    @GeneratedValue(strategy = GenerationType.AUTO) //主键由程序控制
    @Column(name = "order_id", columnDefinition = "int(11)", nullable = false)
    private int orderId; //订单编号id

    @Column(name = "good_id", columnDefinition = "int(11)", nullable = false)
    private int goodId; //商品编号编号id

    @Column(name = "order_money", columnDefinition = "double(0)", nullable = false)
    private double orderMoney; //订单金额

    @Column(name = "receiver_address", columnDefinition = "varchar(255)", nullable = false)
    private String receiverAddress; //收货地址

    @Column(name = "receiver_name", columnDefinition = "varchar(255)", nullable = false)
    private String receiverName; //收货姓名

    @Column(name = "receiver_phone", columnDefinition = "varchar(255)", nullable = false)
    private String receiverPhone; //手机号

}
