package com.thinkingcao.springbootmongodb.service;

import com.thinkingcao.springbootmongodb.entity.Order;
import com.thinkingcao.springbootmongodb.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @desc:
 * @author: cao_wencao
 * @date: 2019-12-05 18:03
 */
public interface OrderService {

    Order addOrder(Order order);

    void deleteOrderByOrderId(String orderId);

    Order updateOrder(Order order);

    Order findOrderByOrderId(String orderId);

    List<Order> findAllOrder();



}
