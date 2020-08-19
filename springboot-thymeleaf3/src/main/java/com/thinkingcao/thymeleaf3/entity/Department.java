package com.thinkingcao.thymeleaf3.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @desc: 部门实体类
 * @author: cao_wencao
 * @date: 2020-08-19 14:20
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Department {
    private Integer id;	// 部门编号
    private String departmentName; // 部门名称
    private String position;	// 部门职位
}
