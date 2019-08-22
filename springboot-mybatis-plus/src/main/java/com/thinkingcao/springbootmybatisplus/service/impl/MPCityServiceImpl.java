package com.thinkingcao.springbootmybatisplus.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.fengwenyi.javalib.util.ExceptionUtil;
import com.thinkingcao.springbootmybatisplus.dao.CityDao;
import com.thinkingcao.springbootmybatisplus.entity.City;
import com.thinkingcao.springbootmybatisplus.service.MPCityService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <pre>
 * @desc:
 * @author: cao_wencao
 * @date: 2019-08-21 17:32
 * @version: 1.0
 * </pre>
 */
@Service
@Slf4j
public class MPCityServiceImpl extends ServiceImpl<CityDao, City> implements MPCityService {

    @Override
    public List<City> queryCityAll() {
        return list(null);
    }

    @Override
    public boolean addCity(City city) {

        ExceptionUtil.notNull(city, "City must not null");

        String name = city.getName();

        if (queryCityByName(name) == null) {
            return save(city);
        }

        // 数据库已经存在
        return true;
    }

    @Override
    public City queryCityByName(String name) {

        ExceptionUtil.notNull(name, "City name must not null");

        QueryWrapper<City> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq(City.NAME, name);

        List<City> cityList = list(queryWrapper);

        if (cityList == null || cityList.size() == 0) {
            return null;
        }

        if (cityList.size() > 1) {
            log.error("queryCityByName结果有多个，name={}", name);
        }

        return cityList.get(0);
    }
}
