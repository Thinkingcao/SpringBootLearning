package com.example.springboot.mapper1;

import com.example.springboot.entity.Order;

import java.util.List;

/**
 * (TOrder)表数据库访问层
 *
 * @author makejava
 * @since 2020-11-12 14:30:22
 */
public interface OrderMapper1 {

    List<Order> getAllOrder();

}