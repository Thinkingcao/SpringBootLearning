package com.thinkingcao.dubbo.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.thinkingcao.dubbo.entity.UserDO;
import com.thinkingcao.dubbo.service.UserService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * <pr>
 * @类名称：HelloController
 * @类描述：TODO
 * @作者：Lv Ming 
 * @日期：2018年12月20日 
 * @版本：V1.0 </pr>
 */
@RestController
@RequestMapping("/user")
public class UserController {

	@Reference
	private UserService userService;

	@GetMapping("/findById/{id}")
	public UserDO findById(@PathVariable Long id) {
		return userService.findById(id);
	}

	@GetMapping("/listUser")
	public List<UserDO> listUser() {
		return userService.listUser();
	}
}