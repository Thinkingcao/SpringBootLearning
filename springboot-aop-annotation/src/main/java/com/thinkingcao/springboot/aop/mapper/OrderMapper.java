package com.thinkingcao.springboot.aop.mapper;

import com.thinkingcao.springboot.aop.entity.Order;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Options;

/**
 * @desc: 订单mapper
 * @auth: cao_wencao
 * @date: 2019/12/19 22:20
 */
public interface OrderMapper {
	// @Insert("insert order_info values (null,#{orderName},#{orderDes})")
	@Insert("INSERT  INTO `t_order` (order_id,order_money,receiver_address,receiver_name,receiver_phone) VALUES (#{orderId},#{orderMoney},#{receiverAddress},#{receiverName},#{receiverPhone});")
	@Options(keyProperty="order.orderId",keyColumn="order_id",useGeneratedKeys=true)
	public int addOrder(Order order);
}
