package com.example.springboot.service.impl;

import com.example.springboot.entity.Order;
import com.example.springboot.mapper1.OrderMapper1;
import com.example.springboot.mapper2.OrderMapper2;
import com.example.springboot.service.IOrderService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @desc:
 * @author: cao_wencao
 * @date: 2020-11-13 16:19
 */
@Service
public class OrderServiceImpl implements IOrderService {

    @Resource
    private OrderMapper1 orderMapper1;

    @Resource
    private OrderMapper2 orderMapper2;

    @Override
    public List<Order> getAllOrder11() {
        return orderMapper1.getAllOrder();
    }

    @Override
    public List<Order> getAllOrder22() {
        return orderMapper2.getAllOrder();
    }
}
