package com.thinkingcao.springboot.memcached.service.Impl;

import com.alibaba.fastjson.JSON;
import com.thinkingcao.springboot.memcached.entity.TblHouse;
import com.thinkingcao.springboot.memcached.service.HouseManageCacheService;
import com.thinkingcao.springboot.memcached.service.TblHouseService;
import lombok.extern.slf4j.Slf4j;
import net.rubyeye.xmemcached.MemcachedClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author : wang zns
 * @date : 2018-12-19
 */
@Service
@Slf4j
public class HouseManageCacheServiceImpl implements HouseManageCacheService {

    @Autowired
    private MemcachedClient memcachedClient;

    @Autowired
    private TblHouseService iTblHouseService;

    @Override
    public void add(TblHouse tblHouse) {
        // 先入库，入库成功则入缓存
        boolean isSuccess = iTblHouseService.insert(tblHouse);
        if (isSuccess) {
            try {
                String houseJsonStr = JSON.toJSONString(tblHouse);
                memcachedClient.set(String.valueOf(tblHouse.getId()),0,houseJsonStr);
            } catch (Exception e) {
                log.info("exception happens when add House:{}",e.toString());
                throw new RuntimeException(e.getMessage());
            }
        }
    }

    @Override
    public void delete(Integer tblHouseId) {
        // 先删除数据库内容，成功则清空缓存
        boolean isSuccess = iTblHouseService.del(tblHouseId);
        if (isSuccess) {
            try {
                memcachedClient.delete(String.valueOf(tblHouseId));
            } catch (Exception e) {
                log.info("exception happens when delete House:{}",e.toString());
                throw new RuntimeException(e.getMessage());
            }
        }
    }

}