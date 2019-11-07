package com.thinkingcao.dubbo.service;

import com.thinkingcao.dubbo.entity.UserDO;

import javax.validation.constraints.NotBlank;
import java.util.List;

/**
 * <p>
 * @类名称：UserService 
 * @类描述：
 * @作者：Lv Ming 
 * @日期：2018年12月20日 
 * @版本：V1.0
 * </p>
 */
public interface UserService {

	/**
	 * 通过id查询用户
	 * 
	 * @param id
	 * @return T @日期：2018年6月17日
	 */
	public UserDO findById(@NotBlank Long id);

	/**
	 * 查询用户列表
	 * 
	 * @return List<T> @日期：2018年6月17日
	 */
	public List<UserDO> listUser();

}