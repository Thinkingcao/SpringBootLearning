package com.example.pagehelper.repository;

import com.example.pagehelper.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @desc:  商品持久类
 * @author: cao_wencao
 * @date: 2020-11-10 17:15
 */
@Repository
public interface ProductDao extends JpaRepository<Product,Integer> {
}
