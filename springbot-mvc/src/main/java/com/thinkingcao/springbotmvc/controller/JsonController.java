package com.thinkingcao.springbotmvc.controller;

import com.thinkingcao.springbotmvc.entity.Product;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

/**
 * @desc: JSON类型的返回
 * @author: cao_wencao
 * @date: 2020-08-24 10:29
 */
@RestController
public class JsonController {

    @RequestMapping("/productJson")
    public Product productJson() {
        Product product = new Product();
        product.setProductNo("036594866121080832");
        product.setProductName("杨枝甘露");
        product.setProductDesc(" 中杯 7分甜 去冰");
        product.setProductNum("1000");
        product.setProductPrice("10");
        return product;
    }

    @RequestMapping("/productJson1")
    public List<Product> productJson1() {
        List<Product> productList = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            Product product = new Product();
            product.setProductNo("036594866121080832"+i);
            product.setProductName("杨枝甘露"+i);
            product.setProductDesc(" 中杯 7分甜 去冰");
            product.setProductNum("1000"+i);
            product.setProductPrice("10"+i);
            productList.add(product);
            productList.add(product);
        }
        return productList;
    }

}
