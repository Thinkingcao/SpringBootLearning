package com.thinkingcao.demo.easypoi.service;

import com.google.common.collect.Lists;
import com.thinkingcao.demo.easypoi.entity.User;
import com.thinkingcao.demo.easypoi.utils.DateUtils;
import org.springframework.stereotype.Service;

import java.util.List;

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
		user.setBirthday(DateUtils.parseDate("2018-12-13"));
		User user1 = new User();
		user1.setId(20);
		user1.setName("李四");
		user1.setSex("男");
		user1.setBirthday(DateUtils.parseDate("2018-12-11"));
		User user2 = new User();
		user2.setId(20);
		user2.setName("王五");
		user2.setSex("男");
		user2.setBirthday(DateUtils.parseDate("2018-12-12"));
		list.add(user);
		list.add(user1);
		list.add(user2);
		listAll.addAll(list);
		return listAll;
	}
}
