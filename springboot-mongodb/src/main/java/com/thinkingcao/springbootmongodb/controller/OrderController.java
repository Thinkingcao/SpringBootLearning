package com.thinkingcao.springbootmongodb.controller;

import com.thinkingcao.springbootmongodb.dao.OrderDao;
import com.thinkingcao.springbootmongodb.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @desc:
 * @author: cao_wencao
 * @date: 2019-12-05 18:03
 */
@RestController
public class OrderController {


    @Autowired
    private OrderService orderService;
    @Autowired
    private OrderDao orderDao;

   /* @RequestMapping("/students")
    Object queryStudents() {
        return studentService.queryStudents();
    }*/

    @RequestMapping("/order/{orderId}")
    Object queryStudentByName(@PathVariable String orderId) {
        return orderService.findByOrderId(orderId);
    }

}
