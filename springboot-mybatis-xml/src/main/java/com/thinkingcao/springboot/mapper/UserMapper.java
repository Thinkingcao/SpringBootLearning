package com.thinkingcao.springboot.mapper;

import com.thinkingcao.springboot.entity.User;
import org.apache.ibatis.annotations.*;

import java.util.List;

/**
 * @desc: UserMapper持久层
 * @auth: cao_wencao
 * @date: 2019/11/14 17:34
 */
@Mapper
public interface UserMapper {

    //查询所有用户
    // @Select("select * from user")
    public List<User> getAllUser();

    //根据id查询单个用户
   // @Select("select * from user where id=#{id}")
    public User getUserById(Integer id);

    //根据id删除单个用户
   // @Delete("delete from user where id=#{id}")
    public int delUserById(Integer id);

    //更新单个用户
   // @Update("update user set gender=#{gender},age=#{age},address=#{address},qq=#{qq},email=#{email} where name=#{name}")
    public int UpdateUser(User user);

    //新增单个用户
    //@Options(useGeneratedKeys = true, keyProperty = "id")//是指定主键生成的并且主键是id
   // @Insert("insert into user(name,gender,age,address,qq,email) values (#{name},#{gender},#{age},#{address},#{qq},#{email})")
    public int InsertUser(User user);

}
