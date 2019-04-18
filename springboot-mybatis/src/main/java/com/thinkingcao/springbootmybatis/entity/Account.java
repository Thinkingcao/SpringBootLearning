package com.thinkingcao.springbootmybatis.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.ToString;

/**
 * <pre>
 *
 * @auther: cao_wencao
 * @date: 2019/2/20 13:34
 * </pre>
 */
@Data
@ToString
@AllArgsConstructor
public class Account {
    private int id ;
    private String name ;
    private double money;


}
