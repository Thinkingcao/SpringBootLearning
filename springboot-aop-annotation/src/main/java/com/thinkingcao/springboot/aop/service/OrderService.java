package com.thinkingcao.springboot.aop.service;

import com.thinkingcao.springboot.aop.entity.Order;
import com.thinkingcao.springboot.aop.mapper.OrderMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @desc:
 * @author: cao_wencao
 * @date: 2019-12-19 22:48
 */
@Service
public class OrderService {
    
    @Autowired
    private OrderMapper orderMapper;

    public int addOrder(Order order){
        return orderMapper.addOrder(order);
    }

}
