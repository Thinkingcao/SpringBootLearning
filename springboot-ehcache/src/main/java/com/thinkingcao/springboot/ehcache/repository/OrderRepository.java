package com.thinkingcao.springboot.ehcache.repository;

import com.thinkingcao.springboot.ehcache.entity.Order;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @desc:
 * @author: cao_wencao
 * @date: 2019-12-11 14:18
 */
public interface OrderRepository extends JpaRepository<Order, Integer> {
}
