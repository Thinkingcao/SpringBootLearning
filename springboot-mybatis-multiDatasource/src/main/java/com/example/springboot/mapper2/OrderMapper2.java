package com.example.springboot.mapper2;

import com.example.springboot.entity.Order;

import java.util.List;

/**
 * (TOrder)表数据库访问层
 *
 * @author makejava
 * @since 2020-11-12 14:30:22
 */
public interface OrderMapper2 {

    List<Order> getAllOrder();

   /* *//**
     * 通过ID查询单条数据
     *
     * @param oid 主键
     * @return 实例对象
     *//*
    Order queryById(Integer oid);

    *//**
     * 查询指定行数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     *//*
    List<Order> queryAllByLimit(@Param("offset") int offset, @Param("limit") int limit);


    *//**
     * 通过实体作为筛选条件查询
     *
     * @param order 实例对象
     * @return 对象列表
     *//*
    List<Order> queryAll(Order order);

    *//**
     * 新增数据
     *
     * @param order 实例对象
     * @return 影响行数
     *//*
    int insert(Order order);

    *//**
     * 修改数据
     *
     * @param order 实例对象
     * @return 影响行数
     *//*
    int update(Order order);

    *//**
     * 通过主键删除数据
     *
     * @param oid 主键
     * @return 影响行数
     *//*
    int deleteById(Integer oid);
*/
}