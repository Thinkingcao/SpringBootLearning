package com.example.pagehelper.service.impl;

import com.example.pagehelper.entity.Order;
import com.example.pagehelper.mapper.OrderMapper;
import com.example.pagehelper.service.OrderService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * (TOrder)表服务实现类
 *
 * @author makejava
 * @since 2020-11-12 14:30:25
 */
@Service("orderService")
public class OrderServiceImpl implements OrderService {
    @Resource
    private OrderMapper orderMapper;

    /**
     * 通过ID查询单条数据
     *
     * @param oid 主键
     * @return 实例对象
     */
    @Override
    public Order queryById(Integer oid) {
        return this.orderMapper.queryById(oid);
    }

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    @Override
    public List<Order> queryAllByLimit(int offset, int limit) {
        return this.orderMapper.queryAllByLimit(offset, limit);
    }

    /**
     * 查询所有数据
     * @return
     */
    @Override
    public List<Order> selectAll() {
        return this.orderMapper.queryAll(null);
    }

    /**
     * 新增数据
     *
     * @param order 实例对象
     * @return 实例对象
     */
    @Override
    public Order insert(Order order) {
        this.orderMapper.insert(order);
        return order;
    }

    /**
     * 修改数据
     *
     * @param order 实例对象
     * @return 实例对象
     */
    @Override
    public Order update(Order order) {
        this.orderMapper.update(order);
        return this.queryById(order.getOid());
    }

    /**
     * 通过主键删除数据
     *
     * @param oid 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(Integer oid) {
        return this.orderMapper.deleteById(oid) > 0;
    }
}