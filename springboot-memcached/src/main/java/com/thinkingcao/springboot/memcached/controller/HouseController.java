package com.thinkingcao.springboot.memcached.controller;

import com.thinkingcao.springboot.memcached.config.MemcachedProperties;
import com.thinkingcao.springboot.memcached.entity.TblHouse;
import com.thinkingcao.springboot.memcached.enums.BizExceptionEnum;
import com.thinkingcao.springboot.memcached.service.HouseManageCacheService;
import com.thinkingcao.springboot.memcached.service.TblHouseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.validation.Valid;

/**
 * @desc:
 * @author: cao_wencao
 * @date: 2020-01-06 10:14
 */
@Controller
public class HouseController {

    @Autowired
    private MemcachedProperties memcachedProperties;

    @Autowired
    private HouseManageCacheService houseManageCacheService;

    @Autowired
    private TblHouseService tblHouseService;

    /**
     * 新增房屋管理
     */
    @RequestMapping(value = "/add")
    @ResponseBody
    public Object add(@Valid TblHouse tblHouse, BindingResult bindingResult) {
        if(bindingResult.hasErrors()){
          //  throw new ServiceException(BizExceptionEnum.REQUEST_NULL);
        }
        // 如果确定要使用缓存
        if (memcachedProperties.isEnabled()) {
            houseManageCacheService.add(tblHouse);
        } else {
            tblHouseService.insert(tblHouse);
        }
        return "";
    }

    /**
     * 删除房屋管理
     */
    @RequestMapping(value = "/delete")
    @ResponseBody
    public Object delete(@RequestParam Integer tblHouseId) {
        if (memcachedProperties.isEnabled()) {
            houseManageCacheService.delete(tblHouseId);
        } else {
            tblHouseService.del(tblHouseId);
        }
        return "";
    }

}
