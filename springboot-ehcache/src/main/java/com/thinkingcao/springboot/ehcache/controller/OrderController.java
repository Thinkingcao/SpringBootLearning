package com.thinkingcao.springboot.ehcache.controller;

import com.thinkingcao.springboot.ehcache.entity.Order;
import com.thinkingcao.springboot.ehcache.result.ResponseCode;
import com.thinkingcao.springboot.ehcache.service.IOrderService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.web.bind.annotation.*;

/**
 * @desc: 订单controller
 * @author: cao_wencao
 * @date: 2019-12-11 14:29
 */
@RestController
@Slf4j
public class OrderController {

    @Autowired
    private IOrderService orderService;

    /**
     * @desc: 查询订单-查询订单之前先查缓存
     * @url: http://127.0.0.1:8080/findOrder?orderId=3
     * @param orderId
     * @date: 2019/12/11 11:36
     */
    @GetMapping("/findOrder")
    public ResponseCode find(@RequestParam Integer orderId) {
        Order order = orderService.findOne(orderId);
        return ResponseCode.success("查询订单成功", order);
    }

    /**
     * @desc: 保存订单-保存订单同时保存到缓存
     * @url：  http://127.0.0.1:8080/save
     * @json： {"orderId":3,"goodId":1,"orderMoney":1.0,"receiverAddress":"上海市徐汇区","receiverName":"曹","receiverPhone":"13027179292"}
     * @param order
     * @date: 2019/12/11 11:36
     */
    @PostMapping("/save")
    public ResponseCode save(@RequestBody Order order) {
         orderService.saveOne(order);
        return ResponseCode.success("保存订单成功");
    }

    /**
     * @desc: 删除订单-删除订单同时删除缓存
     * @url:  http://127.0.0.1:8080/del?orderId=3
     * @param orderId
     * @date: 2019/12/11 11:36
     */
    @GetMapping("del")
    public ResponseCode delete(@RequestParam Integer orderId) {
        orderService.deleteOne(orderId);
        return ResponseCode.success("删除订单成功");
    }


    /**
     * @desc: 删除缓存,若需移除全部缓存,则设置allEntries = true,注解: @CacheEvict(value = "order",key = "#orderId", allEntries = true)
     * @url:  http://127.0.0.1:8080/deleteCache?orderId=3
     * @param orderId
     * @date: 2019/12/11 11:36
     */
    @GetMapping("/deleteCache")
    @CacheEvict(value = "order", key = "#orderId")
    public ResponseCode deleteCache(Integer orderId) {
        log.info("删除缓存成功, orderId为：{}" , orderId);
        return ResponseCode.success("删除缓存成功");
    }
}
