package com.thinkingcao.dubbo.serviceImpl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.alibaba.dubbo.config.annotation.Service;
import com.thinkingcao.dubbo.entity.UserDO;
import com.thinkingcao.dubbo.service.UserService;

/**
 * <p>
 * @类名称：UserServiceImpl
 * @类描述：实现用户管理接口
 * @作者：Lv Ming 
 * @日期：2018年12月20日 
 * @版本：V1.0
 * </p>
 */
@Service(interfaceClass = UserService.class)
@Component
public class UserServiceImpl implements UserService {

	@SuppressWarnings("serial")
	private List<UserDO> users = new ArrayList<UserDO>() {
		{
			add(new UserDO(1L, "熊大", "123"));
			add(new UserDO(2L, "熊二", "234"));
			add(new UserDO(3L, "熊三", "456"));
		}
	};

	/**
	 * <p>
	 * 覆盖方法：findById	
	 * 描述：通过id查询用户	
	 * @param id
	 * @return
	 * @see com.dubbo.api.UserService#findById(java.lang.Long)
	 * </p>
	 */
	@Override
	public UserDO findById(Long id) {
		return users.stream().filter(user -> user.getId() == id).findFirst().get();
	}

	/**
	 * <p>
	 * 覆盖方法：listUser
	 * 描述：查询用户列表
	 * @return
	 * @see com.dubbo.api.UserService#listUser()
	 * </p>
	 */
	@Override
	public List<UserDO> listUser() {
		return users;
	}

}