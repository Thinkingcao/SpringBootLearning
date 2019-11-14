package com.thinkingcao.springboot.entity;

import lombok.Data;

/**
 * @desc: User实体类
 * @author: cao_wencao
 * @date: 2019-11-14 17:32
 */
@Data
public class User {
        private Integer id;
        private String name;
        private String gender;
        private Integer age;
        private String address;
        private String qq;
        private String email;
}
