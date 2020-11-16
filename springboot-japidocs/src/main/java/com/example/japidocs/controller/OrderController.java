package com.example.japidocs.controller;

import com.example.japidocs.entity.Order;
import com.example.japidocs.result.RestResponse;
import com.example.japidocs.service.OrderService;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * (TOrder)表控制层
 *
 * @author makejava
 * @since 2020-11-12 14:30:25
 */
@RestController
@RequestMapping("/openApi/order")
public class OrderController {
    /**
     * 服务对象
     */
    @Autowired
    private OrderService orderService;

    /**
     * 通过主键查询单条数据
     * http://127.0.0.1:8082/openApi/order/findProductByPid/1
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("/selectOne/{id}")
    public RestResponse selectOne(@PathVariable("id") Integer id) {
        Order order = this.orderService.queryById(id);
        return RestResponse.success("查询成功", order);
    }

    /**
     * 查询多条订单数据
     * http://127.0.0.1:8082/openApi/order/selectAllOrder
     * @return
     */
    @GetMapping("/selectAllOrder")
    public RestResponse selectAllOrder() {
        List<Order> orderList = orderService.queryAllByLimit(0, 10);
        return RestResponse.success("查询成功", orderList);
    }

    /**
     * 查询多条订单数据
     * http://127.0.0.1:8082/openApi/order/selectAll
     * @return
     */
    @GetMapping("/selectAll")
    public RestResponse selectAll() {
        PageHelper.startPage(1, 5);
        List<Order> orderList = orderService.selectAll();
        return RestResponse.success("查询成功", orderList);
    }

    /**
     * 新增数据
     * http://127.0.0.1:8082/openApi/order/insertOrder
     * @param order 实例对象
     * @return 实例对象
     */
    @PostMapping("/insertOrder")
    public RestResponse insert(@RequestBody Order order){
        Order result = orderService.insert(order);
        return RestResponse.success("新增成功", result);
    }

    /**
     * 修改数据
     * http://127.0.0.1:8082/openApi/order/updateOrder
     * @param order 实例对象
     * @return 实例对象
     */
    @PostMapping("/updateOrder")
    public RestResponse update(@RequestBody Order order){
        Order result = orderService.update(order);
        if (null== result){
            return RestResponse.fail("修改失败");
        }
        return RestResponse.success("修改成功");
    }

    /**
     * 通过主键删除数据
     * http://127.0.0.1:8082/openApi/order/deleteOrderById/oid
     * @param oid 主键
     * @return 是否成功
     */
    @PostMapping("/deleteOrderById/{oid}")
    public RestResponse deleteById(@PathVariable("oid") Integer oid){
        boolean flag = orderService.deleteById(oid);
        if (!flag){
            return RestResponse.fail("删除失败");
        }
        return RestResponse.success("删除成功");
    }


}