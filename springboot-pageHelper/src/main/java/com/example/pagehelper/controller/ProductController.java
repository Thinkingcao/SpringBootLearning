package com.example.pagehelper.controller;

import com.alibaba.fastjson.JSON;
import com.example.pagehelper.entity.Product;
import com.example.pagehelper.service.ProductService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @desc:
 * @author: cao_wencao
 * @date: 2020-11-10 17:22
 */
@RestController
@Slf4j
@RequestMapping("/openApi/product")
public class ProductController {

    @Autowired
    private ProductService productService;

    /**
     * 根据pid查询单个商品信息
     * http://127.0.0.1:8082/openApi/product/findProductByPid/1
     * @param pid
     * @return
     */
    @RequestMapping(value = "findProductByPid/{pid}", method = RequestMethod.POST)
    public Product findProductByPid(@PathVariable("pid") Integer pid) {
        log.info("接下来要进行{}号商品信息的查询", pid);
        Product product = productService.findByPid(pid);
        log.info("商品信息查询成功,内容为{}", JSON.toJSONString(product));
        return product;
    }

    /**
     * 查询所有商品信息
     * http://127.0.0.1:8082/openApi/product/findAllProduct
     * @return
     */
    @RequestMapping(value = "/findAllProduct", method = RequestMethod.GET)
    public List<Product> findAllProduct() {
        List<Product> products = productService.findAllProduct();
        log.info("商品信息查询成功,内容为{}", JSON.toJSONString(products));
        return products;
    }

    /**
     * 新增商品信息
     * http://127.0.0.1:8082/openApi/product/insertProduct
     * @param product
     */
    @RequestMapping(value = "/insertProduct", method = RequestMethod.POST)
    public void insertProduct(@RequestBody Product product){
        log.info("接下来要新增商品信息: {} ", product);
        productService.insertProduct(product);
    }
}
