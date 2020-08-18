package com.thinkingcao.thymeleaf3.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @desc:
 * @author: cao_wencao
 * @date: 2020-08-17 22:14
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ThObject {
    private Long id;
    private String thName;
    private String desc;
}
