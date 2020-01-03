package com.thinkingcao.rocketmq.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;


/**
 * <pre>
 * @desc: 用户信息实体类
 * @auth: cao_wencao
 * @date: 2019/6/10 15:57
 * @param null
 * </pre>
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UserMsg implements Serializable {
    private long userId;
    private String name;
    private int age;
    private String address;
}
