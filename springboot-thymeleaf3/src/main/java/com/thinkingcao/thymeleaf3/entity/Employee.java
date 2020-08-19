package com.thinkingcao.thymeleaf3.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

/**
 * @desc: 员工实体类
 * @author: cao_wencao
 * @date: 2020-08-19 14:19
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Employee {
    private Integer id;     // 员工编号
    private String lastName;// 员工昵称
    private String email;   // 内部邮箱
    private Integer gender; // 性别：1 表示男性，0表示女性
    private Department department; // 员工所在部门
    private Date birth;     // 员工生日
}
