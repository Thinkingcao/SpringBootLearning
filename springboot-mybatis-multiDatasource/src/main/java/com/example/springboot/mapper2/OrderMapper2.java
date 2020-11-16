package com.example.springboot.mapper2;

import com.example.springboot.entity.Order;

import java.util.List;

/**
 * (TOrder)表数据库访问层
 *
 * @author makejava
 * @since 2020-11-12 14:30:22
 */
public interface OrderMapper2 {

    List<Order> getAllOrder();
}