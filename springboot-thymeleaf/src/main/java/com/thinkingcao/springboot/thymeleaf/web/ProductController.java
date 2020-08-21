package com.thinkingcao.springboot.thymeleaf.web;

import com.thinkingcao.springboot.thymeleaf.entity.Product;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.List;

@Controller
public class ProductController {

    @RequestMapping("/toListPage")
    public String toListPage(){
        return "/product/list";
    }

    @RequestMapping("/getProductInfo")
    public String getProductInfo(Model model, @RequestParam("productNo") String productNo) {
        if (!StringUtils.isEmpty(productNo)) {
            List<Product> ProductList = new ArrayList<>();
            for (int i = 0; i < 10; i++) {
                Product product = new Product();
                product.setProductNo("036594866121080832"+ i);
                product.setProductName("杨枝甘露"+i);
                product.setProductDesc(" 中杯 7分甜 去冰");
                product.setProductNum("1000"+ i);
                product.setProductPrice("10"+i);
                ProductList.add(product);
            }
            model.addAttribute("ProductList", ProductList);
        }
        return "/product/list";
    }
}