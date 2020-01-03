package com.thinkingcao.springboot.mongotemplate.controller;

import com.alibaba.fastjson.JSON;
import com.mongodb.client.result.DeleteResult;
import com.mongodb.client.result.UpdateResult;
import com.thinkingcao.springboot.mongotemplate.entity.Order;
import com.thinkingcao.springboot.mongotemplate.result.ResponseCode;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @desc: Api接口
 * @author: cao_wencao
 * @date: 2020-01-02 17:45
 */
@Slf4j
@RestController
@RequestMapping("/api")
public class OrderController {

    @Autowired
    private MongoTemplate mongoTemplate;

    /**
     * @url:  http://localhost:8080/api/add
     * @desc: 新增订单
     * @auth: cao_wencao
     * @date: 2020/1/2 0:02
     */
    @PostMapping("/add")
    public ResponseCode addOrder(@RequestBody Order order) {
        Order resultOrder = mongoTemplate.save(order);
        log.info("resultOrder : {}", JSON.toJSONString(resultOrder));
        if (null == resultOrder) {
            return ResponseCode.error("新增订单失败");
        }
        return ResponseCode.success("新增订单成功");
    }


    /**
     * @url:  http://localhost:8080/api/update
     * @desc: 更新订单
     * @auth: cao_wencao
     * @date: 2020/1/3 13:11
     */
    @PutMapping("/update")
    public ResponseCode updateOrder(@RequestBody Order order) {
        Query query = new Query(Criteria.where("orderId").is(order.getOrderId()));
        Update update = new Update();
        update.set("orderId", order.getOrderId());
        update.set("goodId", order.getGoodId());
        update.set("orderMoney", order.getOrderMoney());
        update.set("receiverAddress", order.getReceiverAddress());
        update.set("receiverName", order.getReceiverName());
        update.set("receiverPhone", order.getReceiverPhone());
        update.set("payState", order.getPayState());
        update.set("payDate", order.getPayDate());
        UpdateResult updateResult = mongoTemplate.updateFirst(query, update, Order.class);
        log.info("updateResult : {}", JSON.toJSONString(updateResult));
        return ResponseCode.success("更新订单成功", updateResult);
    }

    /**
     * @url:  http://localhost:8080/api/orderId
     * @desc: 根据订单号查询订单
     * @auth: cao_wencao
     * @date: 2020/1/3 13:11
     */
    @GetMapping("/{orderId}")
    public ResponseCode findOrderById(@PathVariable("orderId") String orderId) {
        Query query = new Query(Criteria.where("orderId").is(orderId));
        Order resultOrder =  mongoTemplate.findOne(query, Order.class);
        log.info("resultOrder : {}", JSON.toJSONString(resultOrder));
        return ResponseCode.success("查询成功", resultOrder);
    }

    /**
     * @url:  http://localhost:8080/api/orderId
     * @desc: 根据订单号删除订单
     * @auth: cao_wencao
     * @date: 2020/1/3 13:12
     */
    @DeleteMapping("/{orderId}")
    public ResponseCode deleteOrderById(@PathVariable("orderId") String orderId) {
        //提供两种删除方式
        //通过orderId 删除
        DeleteResult deleteResult =  mongoTemplate.remove(orderId);
        //通过其它唯一标识值删除
        /* String  goodId = "";
        Query queryDelete = new Query().addCriteria(Criteria.where("goodId").is(goodId));
        DeleteResult deleteResult = mongoTemplate.remove(queryDelete,Order.class);*/

        log.info("deleteResult : {}", JSON.toJSONString(deleteResult));
        return ResponseCode.success("删除成功",deleteResult);
    }


    /**
     * @url:  http://localhost:8080/api/list
     * @desc: 查询所有订单数据list
     * @auth: cao_wencao
     * @date: 2020/1/3 13:15
     */
    @GetMapping("/list")
    public ResponseCode findAllOrder() {
        List<Order> orderList = mongoTemplate.findAll(Order.class);
        log.info("orderList : {}", JSON.toJSONString(orderList));
        return ResponseCode.success("删除成功",orderList);
    }
}
