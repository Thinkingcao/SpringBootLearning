package com.thinkingcao.springboot.orika.controller;

import com.thinkingcao.springboot.orika.dto.OrderDTO;
import com.thinkingcao.springboot.orika.entity.OrderResp;
import com.thinkingcao.springboot.orika.result.RestResponse;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import ma.glasnost.orika.MapperFacade;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.math.BigDecimal;
import java.util.Date;

/**
 * @desc: 查询订单列表
 * @author: cao_wencao
 * @date: 2021-04-23 22:59
 */
@Api(value = "查询订单列表API接口",tags="查询订单列表API接口实现")
@Slf4j
@RestController
@RequestMapping(value = "/api/order", produces = "application/json;charset=UTF-8")
public class OrderController {

    @Resource
    private MapperFacade mapperFacade;

    @ApiOperation("查询订单列表")
    @GetMapping("queryOrder/{orderId}")
    public RestResponse queryOrder(@PathVariable("orderId") String orderId){
        OrderDTO orderDTO = new OrderDTO();
        orderDTO.setOrderId("20210424231016");
        orderDTO.setOrderName("点一杯杨枝甘露");
        orderDTO.setOrderTime(new Date());
        orderDTO.setOrderMoney(new BigDecimal(10));
        orderDTO.setOrderAddress("上海市徐汇区");
        //假设上面的orderDTO是通过这一步查询出来的OrderDTO orderDTO = orderService.getOrder(orderId);
        OrderResp orderResp = mapperFacade.map(orderDTO,OrderResp.class);
        return RestResponse.success("订单列表查询成功",orderResp);
    }
}
