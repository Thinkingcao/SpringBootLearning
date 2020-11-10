package com.example.pagehelper.service;

import com.example.pagehelper.entity.Product;

import java.util.List;

/**
 * @desc:  商品接口
 * @author: cao_wencao
 * @date: 2020-11-10 17:18
 */
public interface ProductService {
    //根据pid查询商品信息
    Product findByPid(Integer pid);

    //查询所有商品
    List<Product> findAllProduct();

    void insertProduct(Product product);
}
