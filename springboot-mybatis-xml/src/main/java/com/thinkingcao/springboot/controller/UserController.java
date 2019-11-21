package com.thinkingcao.springboot.controller;

import com.thinkingcao.springboot.entity.User;
import com.thinkingcao.springboot.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @desc: UserController控制层
 * @auth: cao_wencao
 * @date: 2019/11/14 17:35
 */
@Controller
public class UserController {


    @Autowired
    private UserService userService;

    @RequestMapping("/index")
    public String index(Model model) {
        model.addAttribute("users", userService.userList());
        return "list";
    }

    /*查询用户列表*/
    @RequestMapping("/list")
    public String userList(Model model) {
        model.addAttribute("users", userService.userList());
        return "list";
    }

    /*删除用户*/
    @RequestMapping("/del")
    public String deleteUser(Integer id) {
        userService.delete(id);
        return "redirect:/list";
    }

    /*添加用户页面*/
    @RequestMapping("/add")
    public String addUser(ModelMap map) {
        map.addAttribute("user", new User());
        return "add";
    }

    /*更新用户页面*/
    @RequestMapping("/update")
    public String updateUser(Model model,Integer id) {
        User user =userService.getById(id);
        model.addAttribute("user", user);
        return "update";
    }

    /*添加完用户后重定向到list页面*/
    @RequestMapping("/saveI")
    public String saveI(@ModelAttribute User user) {
        userService.insert(user);
        return "redirect:/list";
    }

    /*更新完用户后重定向到list页面*/
    @RequestMapping("/saveU")
    public String saveU(@ModelAttribute User user) {
        userService.update(user);
        return "redirect:/list";
    }
}