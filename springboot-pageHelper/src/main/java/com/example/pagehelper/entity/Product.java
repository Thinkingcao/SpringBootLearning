package com.example.pagehelper.entity;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * @desc:  商品实体类
 * @author: cao_wencao
 * @date: 2020-11-10 23:18
 */
//商品
@Entity(name = "t_product")
@Data
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer pid;//主键

    private String pname;//商品名称
    private Double pprice;//商品价格
    private Integer stock;//库存
}