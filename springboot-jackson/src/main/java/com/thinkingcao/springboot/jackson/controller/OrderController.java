package com.thinkingcao.springboot.jackson.controller;

import com.alibaba.fastjson.JSON;
import com.thinkingcao.springboot.jackson.entity.OrderEntity;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @desc:
 * @author: cao_wencao
 * @date: 2020-01-08 16:47
 */
@RestController
@RequestMapping("/api")
@Slf4j
public class OrderController {




    /**
     * @desc: 新增订单缓存
     * @auth: cao_wencao
     * @date: 2020/1/7 14:03
     */
    @PostMapping("/addOrder")
    public String addOrder(@RequestBody OrderEntity orderEntity) {
        log.info("时间格式为：{}", orderEntity.getPayDate());
        boolean result = this.addOrderEntity(orderEntity);
        log.info("新增的缓存数据为:  {}", result);
        if (!result) {
            return "新增订单缓存失败";
        }
        return "新增订单缓存成功";
    }


    //加入这个是Service层方法
    private Boolean addOrderEntity(OrderEntity orderEntity) {
        String orderJsonStr = JSON.toJSONString(orderEntity);
        boolean result = true;
        return result;
    }
}
