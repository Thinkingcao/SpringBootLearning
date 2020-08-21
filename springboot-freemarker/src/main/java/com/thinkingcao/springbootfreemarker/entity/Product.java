package com.thinkingcao.springbootfreemarker.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @desc:
 * @author: cao_wencao
 * @date: 2020-08-21 14:24
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Product {
    //商品编号
    private String productNo;
    //商品名称
    private String productName;
    //商品描述
    private String productDesc;
    //商品价格
    private String productPrice;
    //商品库存
    private String productNum;
}