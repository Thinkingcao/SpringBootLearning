package com.thinkingcao.encrypt.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

/**
 * @desc:
 * @author: cao_wencao
 * @date: 2020-05-15 12:51
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Accessors(chain = true)
public class LoginUser {
    private String name;
    private String passward;
}
