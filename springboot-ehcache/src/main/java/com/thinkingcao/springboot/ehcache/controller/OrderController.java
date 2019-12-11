package com.thinkingcao.springboot.ehcache.controller;

import com.thinkingcao.springboot.ehcache.entity.Order;
import com.thinkingcao.springboot.ehcache.service.IOrderService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.web.bind.annotation.*;

/**
 * @desc:
 * @author: cao_wencao
 * @date: 2019-12-11 14:29
 */
@RestController
@Slf4j
public class OrderController {
    @Autowired
    private IOrderService orderService;

    /**
     * 查询用户
     * @param orderId
     * @return
     */
    @GetMapping("/findOrder")
    public Order find(@RequestParam Integer orderId) {
        return orderService.findOne(orderId);
    }

    /**
     * 保存用户
     * @param order
     * @return
     */
    @PostMapping("/save")
    public Order save(@RequestBody Order order) {
        return orderService.saveOne(order);
    }

    /**
     * 删除用户
     * @param orderId
     * @return
     */
    @GetMapping("del")
    public String delete(@RequestParam Integer orderId) {
        orderService.deleteOne(orderId);
        return "delete success";
    }

    /**
     * 删除缓存
     * @return
     */
    @GetMapping("/deleteCache")
    @CacheEvict(value = "order", allEntries = true)
    public void deleteCache() {
        log.info("删除缓存，移除缓存中所有的数据");
    }
}
