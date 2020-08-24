package com.thinkingcao.springbotmvc.controller;

import com.alibaba.fastjson.JSON;
import com.thinkingcao.springbotmvc.entity.Product;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

/**
 * @desc: Void类型的返回
 * @author: cao_wencao
 * @date: 2020-08-24 10:27
 */
@Controller
public class VoidController {

    @RequestMapping("/voidAndWrite")
    @ResponseBody
    public void productVoid(HttpServletResponse response) throws IOException {
        List<Product> list = new ArrayList<Product>();
        Product product = new Product();
        product.setProductNo("036594866121080832");
        product.setProductName("杨枝甘露");
        product.setProductDesc("中杯 7分甜 去冰");
        product.setProductPrice("999");
        product.setProductNum("1000");
        list.add(product);
        String jsonStr = JSON.toJSONString(list);
        System.out.println("jsonStr = " + jsonStr);
        //将json转发到浏览器
        //response.getWriter().write(jsonStr);
    }

    @RequestMapping("/voidAndRedirect")
    public void redirectVoid(HttpServletResponse response) throws IOException {
        response.sendRedirect("/product/redirect");
    }

    /**
     * 封装给redirect重定向后的方法
     *
     * @return
     */
    @RequestMapping("/product/redirect")
    public String redirect() {
        return "/product/redirect";
    }

    @RequestMapping("/voidAndForward")
    public void forwardVoid(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        request.getRequestDispatcher("/product/forward").forward(request, response);
    }

    /**
     * 封装给forward转发后的方法
     *
     * @return
     */
    @RequestMapping("/product/forward")
    public String forward() {
        return "/product/forward";
    }


    @RequestMapping("/voidAndOutFlush")
    @ResponseBody
    public void outFlushVoid(HttpServletResponse resp) throws IOException {
        resp.setContentType("application/json;charset=utf-8");
        List<Product> list = new ArrayList<Product>();
        Product product = new Product();
        product.setProductNo("036594866121080832");
        product.setProductName("杨枝甘露");
        product.setProductDesc("中杯 7分甜 去冰");
        product.setProductPrice("999");
        product.setProductNum("1000");
        list.add(product);
        String jsonStr = JSON.toJSONString(list);
        System.out.println("jsonStr = " + jsonStr);
        PrintWriter out = resp.getWriter();
        out.write(jsonStr);
        out.flush();
        out.close();
    }

}
