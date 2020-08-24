package com.thinkingcao.springbotmvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @desc: String类型的返回
 * @author: cao_wencao
 * @date: 2020-08-24 10:28
 */
@Controller
public class StringController {

    @RequestMapping("/productStr1")
    public String productStr(Model model) {
        model.addAttribute("productName", "杨枝甘露1");
        model.addAttribute("productNo", "9999");
        return "/product/productInfo";
    }

    @RequestMapping("/productStr2")
    public String productStr2(ModelMap modelMap) {
        modelMap.addAttribute("productName", "杨枝甘露2");
        modelMap.addAttribute("productNo", "1000");
        return "/product/productInfo";
    }

    @RequestMapping("/productStr")
    @ResponseBody
    public String productStr() {
        return "点一杯杨枝甘露";
    }

    @RequestMapping("/productString")
    public String productString(Model model) {
        model.addAttribute("productNo", "24099");
        model.addAttribute("productName", "杨枝甘露");
        return "/product/productInfo";
    }

    @RequestMapping("/redirectAndString")
    public String redirectAndString() {
        return "redirect:/product/redirect";
    }


    @RequestMapping("/forwardAndString")
    public String forwardAndString() {
        return "forward:/product/forward";
    }


    /**
     * Redirect: 重定向后的方法，重定向地址栏变化
     * @return
     */
    @RequestMapping("/product/productStrByRedirect")
    public String redirect(){
        return "/product/redirect";
    }

    ///**
    // * Forward: 转发后的方法,转发地址栏不变化
    // * @return
    // */
    //@RequestMapping("/product/productStrByForward")
    //public String forward(){
    //   return "/product/forward";
    //}

}
