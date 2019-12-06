package com.thinkingcao.springbootxml.service;

import lombok.extern.slf4j.Slf4j;

/**
 * @desc: 启动项目,如果打印下面log中的一段话，说明OrderService被Spring容器new过
 * @author: cao_wencao
 * @date: 2019-12-06 19:26
 */
@Slf4j
public class OrderService {

    public OrderService() {
        log.info("在xml中定义bean,可使用SprigBoot导入xml配置文件");
    }
}
