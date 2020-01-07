package com.thinkingcao.springboot.memcached.service;

import com.alibaba.fastjson.JSON;
import com.thinkingcao.springboot.memcached.entity.OrderEntity;
import lombok.extern.slf4j.Slf4j;
import net.rubyeye.xmemcached.MemcachedClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @desc: 订单缓存服务接口
 * @author: cao_wencao
 * @date: 2020-01-07 14:06
 */
@Service
@Slf4j
public class OrderCacheService {

    @Autowired
    private MemcachedClient memcachedClient;


    /**
     * @desc: 新增订单缓存
     * @auth: cao_wencao
     * @date: 2020/1/7 14:03
     */
    public Boolean addOrder(OrderEntity orderEntity) {
        String orderJsonStr = JSON.toJSONString(orderEntity);
        boolean result = false;
        // 第一个参数是key，第二个参数是超时时间，第三个参数是value
        try {
            result = memcachedClient.add(orderEntity.getOrderId(), 0, orderJsonStr);
        } catch (Exception e) {
            log.info("新增订单缓存失败 : {}", e.getMessage());
            throw new RuntimeException(e.getMessage());
        }
        return result;
    }


    /**
     * @desc: 查询订单缓存
     * @auth: cao_wencao
     * @date: 2020/1/7 14:03
     */
    public String findOrder(String orderId) {
        OrderEntity orderEntity = null;
        String orderStr = null;
        try {
            // memcachedClient.get
            orderStr = memcachedClient.get(orderId);
        } catch (Exception e) {
            log.info("查询订单缓存失败 : {}", e.getMessage());
            throw new RuntimeException(e.getMessage());
        }
        return orderStr;
    }


    /**
     * @desc: 删除订单缓存
     * @auth: cao_wencao
     * @date: 2020/1/7 14:03
     */
    public Boolean deleteOrder(String orderId) {
        Boolean result = false;
        try {
            result = memcachedClient.delete(orderId);
        } catch (Exception e) {
            log.info("删除订单缓存失败 : {}", e.getMessage());
            throw new RuntimeException(e.getMessage());
        }
        return result;
    }




}
