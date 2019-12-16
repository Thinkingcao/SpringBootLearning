package com.thinkingcao.springboot.token.mapper;

import com.thinkingcao.springboot.token.entity.MemberUser;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

/**
 * @desc: mapperDao
 * @author: cao_wencao
 * @date: 2019-12-16 14:34
 */
//dao层接口，相当于mapperDao，接口的dao层实现
public interface MemberUserDao {

    //通过userId查询用户信息
    @Select("select  id,username,password,phone,email,created,updated from mb_user where id =#{userId}")
    MemberUser findById(@Param("userId") Long userId);

    //会员注册接口
    @Insert("INSERT  INTO `mb_user`  (username,password,phone,email,created,updated) VALUES (#{username}, #{password},#{phone},#{email},#{created},#{updated});")
    Integer insertUser(MemberUser userEntity);

    //使用账号密码登录
    @Select("select  id,username,password,phone,email,created,updated from mb_user where username = #{userName} and password = #{newPassWord}")
    MemberUser login(@Param("userName") String userName, @Param("newPassWord") String newPassWord);
}
