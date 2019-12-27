package com.thinkingcao.springboot.exception.controller;

import com.thinkingcao.springboot.exception.entity.Order;
import com.thinkingcao.springboot.exception.exception.BusinessException;
import com.thinkingcao.springboot.exception.result.ApiResult;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

/**
 * @desc: 订单Controller
 * @author: cao_wencao
 * @date: 2019-12-18 0:01
 */
@Slf4j
@RestController
@RequestMapping("/order")
public class OrderController {

    /**
     * 无异常的请求
     * @return
     */
    @GetMapping("/list")
    public ApiResult list() {
        log.info("查询订单...");
        List<Order> orderList =new ArrayList();
        Order order=new Order();
        order.setOrderId(1);
        order.setOrderMoney(1.2);
        order.setReceiverAddress("https://blog.csdn.net/thinkingcao");
        order.setReceiverName("Thinkingcao");
        order.setReceiverPhone("11111111111");
        orderList.add(order);
        return ApiResult.Success(orderList);
    }

    /**
     * 模拟自定义异常
     * @param order
     * @return
     */
    @PostMapping("/insert")
    public ApiResult insert(@RequestBody Order order) throws BusinessException {
        log.info("新增订单...");
        //如果姓名为空就手动抛出一个自定义的异常！
        if(order.getReceiverName()==null){
            throw new BusinessException(-1,"用户姓名不能为空！");
        }
        return new ApiResult();
    }

    /**
     * 这里故意发送post请求，模拟请求方式错误
     * @param order
     * @return
     */
    @PutMapping("/update")
    public ApiResult update(@RequestBody Order order) {
        log.info("更新订单...");
        return new ApiResult();
    }

    /**
     * 模拟其他异常
     * @param id
     * @return
     */
    @DeleteMapping("/deleteById")
    public ApiResult deleteById(Long id)  {
        log.info("删除订单...");
        //这里故意造成一个异常，并且不进行处理
        Integer.parseInt("abc123");
        return new ApiResult();
    }


}
