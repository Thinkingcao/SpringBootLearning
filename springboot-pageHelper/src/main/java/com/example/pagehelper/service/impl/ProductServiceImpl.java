package com.example.pagehelper.service.impl;

import com.example.pagehelper.entity.Product;
import com.example.pagehelper.repository.ProductDao;
import com.example.pagehelper.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @desc:  商品服务实现类
 * @author: cao_wencao
 * @date: 2020-11-10 17:19
 */
@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductDao productDao;

    @Override
    public Product findByPid(Integer pid) {
        return productDao.findById(pid).get();
    }

    @Override
    public List<Product> findAllProduct() {
        return productDao.findAll();
    }

    @Override
    public void insertProduct(Product product) {
        productDao.save(product);
    }
}
