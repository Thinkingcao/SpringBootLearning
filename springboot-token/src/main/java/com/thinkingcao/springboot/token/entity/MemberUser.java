package com.thinkingcao.springboot.token.entity;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import java.util.Date;


/**
 * @desc: 用户实体类
 * @author: cao_wencao
 * @date: 2019-12-16 13:48
 */
@Getter
@Setter
@ToString
public class MemberUser {

    private Integer id;
    private String username;
    private String password;
    private String phone;
    private String email;
    private Date created;
    private Date updated;

}
