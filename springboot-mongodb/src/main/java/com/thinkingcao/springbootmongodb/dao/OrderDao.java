package com.thinkingcao.springbootmongodb.dao;

import com.thinkingcao.springbootmongodb.entity.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class OrderDao {
    private final MongoTemplate mongoTemplate;

    @Autowired
    public OrderDao(MongoTemplate mongoTemplate) {
        this.mongoTemplate = mongoTemplate;
    }

    public void addOrder(Order order) {
        mongoTemplate.save(order);
    }

    public List<Order> queryStudents() {
        return mongoTemplate.find(null, Order.class);
    }
}