package com.example.springboot.controller;

import com.example.springboot.entity.Order;
import com.example.springboot.service.IOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @desc:
 * @author: cao_wencao
 * @date: 2020-11-13 16:26
 */
@RestController
public class OrderController {

    @Autowired
    private IOrderService orderService;

    @GetMapping("/getAllOrder11")
    public List<Order> getAllOrder11(){
        List<Order> orderList = orderService.getAllOrder11();
        return orderList;
    }

    @GetMapping("/getAllOrder22")
    public List<Order> getAllOrder22(){
        List<Order> orderList = orderService.getAllOrder22();
        return orderList;
    }
}
