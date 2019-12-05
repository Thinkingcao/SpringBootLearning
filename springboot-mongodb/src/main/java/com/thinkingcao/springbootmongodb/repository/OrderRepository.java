package com.thinkingcao.springbootmongodb.repository;

import com.thinkingcao.springbootmongodb.entity.Order;
import org.springframework.data.mongodb.repository.MongoRepository;

/**
 * @desc:  订单数据接口，继承自MongoRepository接口
 * @author: cao_wencao
 * @date: 2019-12-05 17:48
 */
public interface OrderRepository extends MongoRepository<Order,String> {

    public Order findByOrderId(String orderId);
}
