package com.thinkingcao.springbootfreemarker.web;


import com.thinkingcao.springbootfreemarker.config.ResourceProperties;
import com.thinkingcao.springbootfreemarker.entity.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.List;

@Controller
public class FreeMarkerController {

    @Autowired
    private ResourceProperties resourceProperties;

    @RequestMapping(value = "index")
    public String index(ModelMap map){
        map.addAttribute("resource", resourceProperties);
        return "freemarker/index";
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
            model.addAttribute("productList", ProductList);
        }
        return "freemarker/product/list";
    }

}
