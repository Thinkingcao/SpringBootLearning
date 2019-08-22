package com.thinkingcao.springbootmybatisplus.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.thinkingcao.springbootmybatisplus.entity.City;

import java.util.List;

/**
 * <pre>
 * @desc:
 * @author: cao_wencao
 * @date: 2019-08-21 17:42
 * @version: 1.0
 * </pre>
 */
public interface MPCityService extends IService<City> {

    List<City> queryCityAll();

    boolean addCity(City city);

    City queryCityByName(String name);

}