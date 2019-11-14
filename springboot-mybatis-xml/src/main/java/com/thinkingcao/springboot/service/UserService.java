package com.thinkingcao.springboot.service;

import com.thinkingcao.springboot.entity.User;
import com.thinkingcao.springboot.mapper.UserMapper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @desc: UserService业务层
 * @auth: cao_wencao
 * @date: 2019/11/14 17:34
 */
@Service
public class UserService {
    @Resource
    private UserMapper userMapper;

    public List<User> userList(){
        return userMapper.getAllUser();
    }

    public int insert(User user){
        return userMapper.InsertUser(user);
    }

    public int delete(Integer id){
        return userMapper.delUserById(id);
    }

    public int update(User user){
        return userMapper.UpdateUser(user);
    }

    public User getById(Integer id){
        return userMapper.getUserById(id);
    }
}
