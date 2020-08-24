package com.thinkingcao.springbotmvc.controller;

import com.thinkingcao.springbotmvc.entity.Product;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.List;

/**
 * @desc:  ModelAndView类型的返回
 * @author: cao_wencao
 * @date: 2020-08-24 10:19
 */
@Controller
public class ModelAndViewController {

    @RequestMapping("/productView")
    public ModelAndView productView(ModelAndView view){
        List<Product> productList = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            Product product = new Product();
            product.setProductNo("036594866121080832"+ i);
            product.setProductName("杨枝甘露"+i);
            product.setProductDesc(" 中杯 7分甜 去冰");
            product.setProductNum("1000"+ i);
            product.setProductPrice("10"+i);
            productList.add(product);
        }
        view.addObject("productList",productList);
        view.setViewName("/product/product");
        return view;
    }

}
