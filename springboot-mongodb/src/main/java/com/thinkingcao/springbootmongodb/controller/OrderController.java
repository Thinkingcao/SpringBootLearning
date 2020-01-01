package com.thinkingcao.springbootmongodb.controller;

import com.alibaba.fastjson.JSON;
import com.thinkingcao.springbootmongodb.entity.Order;
import com.thinkingcao.springbootmongodb.result.ResponseCode;
import com.thinkingcao.springbootmongodb.service.OrderService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @desc:   Api接口
 * @author: cao_wencao
 * @date: 2019-12-05 18:03
 */
@Slf4j
@RestController
@RequestMapping("/api")
public class OrderController {
    
    @Autowired
    private OrderService orderService;


    @PostMapping("/add")
    public ResponseCode addOrder(@RequestBody Order order){
        Order resultOrder =  orderService.addOrder(order);
        log.info("resultOrder : {}", JSON.toJSONString(resultOrder));
        if (null == resultOrder)
        {
            return ResponseCode.error("新增订单缓存失败");
        }
        return ResponseCode.success("新增订单缓存成功");
    }

    @PutMapping("/update")
    public Order updateOrder(@RequestBody Order order){
        return orderService.updateOrder(order);
    }

    @GetMapping("/{id}")
    public Order findOrderById(@PathVariable("id") String id){
        return orderService.findOrderByOrderId(id);
    }

    @DeleteMapping("/{id}")
    public void deleteOrderById(@PathVariable("id") String id){
        orderService.deleteOrderByOrderId(id);
    }

    @GetMapping("/list")
    public List<Order> findAllOrder(){
        return orderService.findAllOrder();
    }

}
