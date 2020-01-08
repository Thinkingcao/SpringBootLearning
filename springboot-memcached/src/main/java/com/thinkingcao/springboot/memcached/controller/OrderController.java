package com.thinkingcao.springboot.memcached.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.thinkingcao.springboot.memcached.config.MemcachedProperties;
import com.thinkingcao.springboot.memcached.entity.OrderEntity;
import com.thinkingcao.springboot.memcached.enums.BizExceptionEnum;
import com.thinkingcao.springboot.memcached.result.ResponseCode;
import com.thinkingcao.springboot.memcached.service.OrderCacheService;
import lombok.extern.slf4j.Slf4j;
import net.rubyeye.xmemcached.MemcachedClient;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @desc:   Memcached缓存订单APi接口
 * @author: cao_wencao
 * @date: 2020-01-07 14:00
 */
@RestController
@RequestMapping("/api")
@Slf4j
public class OrderController {
    @Autowired
    private MemcachedClient mClient;

    @Autowired
    private MemcachedProperties memcachedProperties;

    @Autowired
    private OrderCacheService orderCacheService;

    /**
     * @desc: 新增订单缓存
     * @auth: cao_wencao
     * @date: 2020/1/7 14:03
     */
    @PostMapping("/addOrder")
    public ResponseCode addOrder(@RequestBody OrderEntity orderEntity) {
        boolean result = false;
        if (memcachedProperties.isEnabled()) {
            result = orderCacheService.addOrder(orderEntity);
            log.info("新增的缓存数据为:  {}", result);
        }
        if (!result) {
            return ResponseCode.error("新增订单缓存失败");
        }
        return ResponseCode.success("新增订单缓存成功", result);
    }


    /**
     * @desc: 查询订单缓存
     * @auth: cao_wencao
     * @date: 2020/1/7 14:03
     */
    @GetMapping("/findOrder/{orderId}")
    public ResponseCode findOrder(@PathVariable("orderId") String orderId) {
        if (StringUtils.isBlank(orderId)) {
            return ResponseCode.error("参数异常", BizExceptionEnum.REQUEST_INVALIDATE);
        }
        String orderStr = null;
        if (memcachedProperties.isEnabled()) {
            orderStr = orderCacheService.findOrder(orderId);
            log.info("查询的缓存数据为:  {}", orderStr);
        }
        if (null == orderStr) {
            return ResponseCode.error("查询订单缓存数据失败");
        }
        //将json字符串转JSON对象，然后输出自动转化为JSON对象
        JSONObject jsonObject = JSON.parseObject(orderStr);
        return ResponseCode.success("查询订单缓存数据成功", jsonObject);
    }


    /**
     * @desc: 删除订单缓存
     * @auth: cao_wencao
     * @date: 2020/1/7 14:03
     */
    @DeleteMapping("/deleteOrder/{orderId}")
    public ResponseCode deleteOrder(@PathVariable("orderId") String orderId) {
        if (StringUtils.isBlank(orderId)) {
            return ResponseCode.error("参数异常");
        }
        Boolean flag = null;
        if (memcachedProperties.isEnabled()) {
            flag = orderCacheService.deleteOrder(orderId);
            log.info("查询的缓存数据为:  {}", flag);
        }
        return ResponseCode.success("删除订单缓存成功", flag);
    }


    /**
     * @desc: 新增对象缓存
     * @auth: cao_wencao
     * @date: 2020/1/8 10:05
     */
    @RequestMapping("/testAddGetDeleteObject")
    public void testAddGetDeleteObject(@RequestBody OrderEntity orderEntity){
        // 1.新增订单
        Boolean flag = orderCacheService.addOrder(orderEntity);
        log.info("新增订单: {}", flag);
        // 2.查询订单
        String orderStr = orderCacheService.findOrder(orderEntity.getOrderId());
        log.info("查询订单: {}", orderStr);
        // 3.删除订单
        Boolean flag1 = orderCacheService.deleteOrder(orderEntity.getOrderId());
        log.info("删除订单: {}", flag1);
    }


    /**
     * @desc: 新增字符串缓存
     * @auth: cao_wencao
     * @date: 2020/1/8 10:05
     */
    @RequestMapping("/testAddGetDeleteUpdateStr")
    public void testAddGetDeleteUpdateStr() throws Exception{
        //新增操作
        mClient.set("Thinkingcao",0,"张三");
        log.info("【新增的数据为】: {}",(String)mClient.get("Thinkingcao"));

        //删除操作
        mClient.delete("Thinkingcao");
        log.info("【删除的数据为】: {}",(String)mClient.get("Thinkingcao"));

        //设置存活时间
        mClient.set("ThinkingcaoQRQ",1,"李四");
        Thread.sleep(2000);
        log.info("【休眠后数据为】: {}",(String)mClient.get("ThinkingcaoQRQ"));

        //更新操作
        mClient.set("ThinkingcaoQAQ",0,"王五");
        log.info("【新增的数据为】: {}",(String)mClient.get("ThinkingcaoQAQ"));
        mClient.set("ThinkingcaoQAQ",0,"王二麻子");
        log.info("【新增的数据为】: {}",(String)mClient.get("ThinkingcaoQAQ"));
    }

}
