package com.thinkingcao.springboot.memcached.service;

import com.thinkingcao.springboot.memcached.entity.TblHouse;

/**
 * @desc:
 * @author: cao_wencao
 * @date: 2020-01-06 10:19
 */
public interface TblHouseService {

    /**
     * 添加
     * @param tblHouse
     */
    boolean insert(TblHouse tblHouse);

    /**
     * 根据主键删除
     * @param tblHouseId
     */
    boolean del(Integer tblHouseId);
}
