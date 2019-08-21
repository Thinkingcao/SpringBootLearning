package com.thinkingcao.demo.easypoi.service;

import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Service;

import com.google.common.collect.Lists;
import com.thinkingcao.demo.easypoi.entity.User;

/**
 * <pre>
 * &#64;author cao_wencao
 * &#64;date 2018年12月13日 下午5:37:17
 * </pre>
 */
@Service
public class UserService {
	
	public List<User> findAll() {
		List<User> listAll = Lists.newArrayList();
		List<User> list = Lists.newArrayList();
		User user = new User();
		user.setId(10);
		user.setName("张三");
		user.setSex("男");
		user.setBirthday(new Date().toString());
		User user1 = new User();
		user1.setId(20);
		user1.setName("李四");
		user1.setSex("男");
		user1.setBirthday(new Date().toString());
		user.setBirthday(new Date().toString());
		User user2 = new User();
		user2.setId(20);
		user2.setName("王五");
		user2.setSex("男");
		user2.setBirthday(new Date().toString());
		list.add(user);
		list.add(user1);
		list.add(user2);
		listAll.addAll(list);
		return listAll;
	}
}
