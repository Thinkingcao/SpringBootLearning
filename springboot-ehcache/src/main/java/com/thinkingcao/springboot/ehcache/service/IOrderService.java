package com.thinkingcao.springboot.ehcache.service;

import com.thinkingcao.springboot.ehcache.entity.Order;

/**
 * @desc: order接口
 * @author: cao_wencao
 * @date: 2019-12-11 14:13
 */
public interface IOrderService {
    /**
     * 根据订单编号id查询订单
     * @param id
     * @return
     */
    Order findOne(Integer id);

    /**
     * 保存一个订单信息
     * @param order
     * @return
     */
    void saveOne(Order order);

    /**
     * 删除一个订单信息
     * @param id
     */
    void deleteOne(Integer id);

}
