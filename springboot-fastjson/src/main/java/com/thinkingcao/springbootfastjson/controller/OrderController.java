package com.thinkingcao.springbootfastjson.controller;

import com.thinkingcao.springbootfastjson.entity.Order;
import com.thinkingcao.springbootfastjson.result.ResponseCode;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @url: http://127.0.0.1:8080/getOrder
 * @desc: 查询订单Controller
 * @author: cao_wencao
 * @date: 2019-12-05 14:24
 */
@RestController
public class OrderController {

    /**
     * @desc: produces = "application/json; charset=utf-8" 的作用是为了传输JSON乱码，指定输出JSON格式为UTF-8
     * @auth: cao_wencao
     * @date: 2019/12/5 14:40
     */
    @RequestMapping(value = "/getOrder",produces = "application/json; charset=utf-8")
    public ResponseCode getOrder(){
        List<Order> orderList = new ArrayList<>();
        Order order = new Order();
        order.setOrderId(1);
        order.setGoodId(1);
        order.setOrderMoney(10.0);
        order.setPayState("已支付");
        order.setReceiverAddress("上海市徐汇区");
        order.setReceiverName("Thinkingcao");
        order.setReceiverPhone("12345678900");
        order.setPayDate(new Date());
        orderList.add(order);
        return ResponseCode.success("查询订单成功", orderList);
    }

}
