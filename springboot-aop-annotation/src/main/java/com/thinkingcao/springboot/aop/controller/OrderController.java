package com.thinkingcao.springboot.aop.controller;

import com.thinkingcao.springboot.aop.annotation.NoRepeatSubmit;
import com.thinkingcao.springboot.aop.entity.Order;
import com.thinkingcao.springboot.aop.mapper.OrderMapper;
import com.thinkingcao.springboot.aop.result.ResponseCode;
import com.thinkingcao.springboot.aop.service.OrderService;
import com.thinkingcao.springboot.aop.utils.Constant;
import com.thinkingcao.springboot.aop.utils.RedisUtil;
import com.thinkingcao.springboot.aop.utils.TokenUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @desc: 订单Controller
 * @author: cao_wencao
 * @date: 2019-12-18 0:01
 */
@RestController
public class OrderController {

    @Autowired
    private OrderMapper orderMapper;

    @Autowired
    private RedisUtil redisUtil;


    @RequestMapping(value = "/getToken")
    public ResponseCode getToken(){
        String token = TokenUtils.getToken();
        //将生成的token存进redis   key：token  value: token   time : 30分钟
        redisUtil.set(token, token, redisUtil.TOKEN_EXPIRE_TIME);
        return ResponseCode.success("获取token成功",token);
    }


    /**
     * @desc: 新增订单
     * @auth: cao_wencao
     * @date: 2019/12/19 22:27
     */
    @RequestMapping(value = "/addOrder", produces = "application/json; charset=utf-8")
    @NoRepeatSubmit(type = Constant.EXTAPIHEAD)
    public ResponseCode addOrder(@RequestBody Order order) {
        int result = orderMapper.addOrder(order);
        if (result > 0) {
            return ResponseCode.success("添加成功！");
        }
        return ResponseCode.error("添加失败！");
    }
}
