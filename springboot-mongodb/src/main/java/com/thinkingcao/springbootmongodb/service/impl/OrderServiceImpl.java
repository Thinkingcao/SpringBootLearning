package com.thinkingcao.springbootmongodb.service.impl;

import com.thinkingcao.springbootmongodb.entity.Order;
import com.thinkingcao.springbootmongodb.repository.OrderRepository;
import com.thinkingcao.springbootmongodb.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @desc:
 * @author: cao_wencao
 * @date: 2020-01-01 1:56
 */
@Service
public class OrderServiceImpl implements OrderService {

    @Autowired
    private OrderRepository orderRepository;


    /**
     * 添加订单信息
     * @param order
     * @return
     */
    @Override
    public Order addOrder(Order order) {
        return orderRepository.save(order);
    }


    /**
     * 根据orderId 删除订单信息
     * @param orderId
     */
    @Override
    public void deleteOrderByOrderId(String orderId) {
        orderRepository.deleteById(orderId);
    }


    /**
     * 更新订单信息
     * @param order
     * @return
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public Order updateOrder(Order order) {
        Order oldOrder = this.findOrderByOrderId(order.getOrderId());
        if (oldOrder != null){
            oldOrder.setGoodId(order.getGoodId());
            oldOrder.setOrderMoney(order.getOrderMoney());
            oldOrder.setPayDate(order.getPayDate());
            oldOrder.setPayState(order.getPayState());
            oldOrder.setReceiverAddress(order.getReceiverAddress());
            oldOrder.setReceiverName(order.getReceiverName());
            oldOrder.setReceiverPhone(order.getReceiverPhone());
            return orderRepository.save(oldOrder);
        } else {
            return null;
        }
       
    }


    /**
     * 根据orderId查询订单信息
     * @param orderId
     * @return
     */
    @Override
    public Order findOrderByOrderId(String orderId) {
        return orderRepository.findByOrderId(orderId);
    }


    /**
     * 查询订单信息列表
     * @return
     */
    @Override
    public List<Order> findAllOrder() {
        return orderRepository.findAll();
    }
}
