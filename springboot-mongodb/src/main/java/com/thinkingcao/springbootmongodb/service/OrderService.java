package com.thinkingcao.springbootmongodb.service;

import com.thinkingcao.springbootmongodb.entity.Order;
import com.thinkingcao.springbootmongodb.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @desc:
 * @author: cao_wencao
 * @date: 2019-12-05 18:03
 */
@Service
public class OrderService {
    @Autowired
    private OrderRepository orderRepository;

    public Order findByOrderId(String orderId){
        return  orderRepository.findByOrderId(orderId);
    }



}
