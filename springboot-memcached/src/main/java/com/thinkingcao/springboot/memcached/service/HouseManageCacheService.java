package com.thinkingcao.springboot.memcached.service;

import com.thinkingcao.springboot.memcached.entity.TblHouse;

/**
 * 房屋管理缓存 业务层
 * @author : wang zns
 * @date : 2018-12-19
 */
public interface HouseManageCacheService {

    /**
     * 添加
     * @param tblHouse
     */
    void add(TblHouse tblHouse);

    /**
     * 根据主键删除
     * @param tblHouseId
     */
    void delete(Integer tblHouseId);
    
}