package com.thinkingcao.springbootmapstruct.mapper;

import com.thinkingcao.springbootmapstruct.entity.Order;
import org.springframework.data.jpa.repository.JpaRepository;


/**
 * <pre>
 * @desc:  OrdersRepository
 * @author: cao_wencao
 * @date: 2019-11-04 22:58
 * @version: 1.0
 * </pre>
 */
public interface OrdersRepository extends JpaRepository<Order,Integer> {
}
