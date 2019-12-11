package com.thinkingcao.springbootdatasource.controller;

import com.thinkingcao.springbootdatasource.entity.TOrder;
import com.thinkingcao.springbootdatasource.service.TOrderService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * (TOrder)表控制层
 *
 * @author makejava
 * @since 2019-11-25 23:08:47
 */
@RestController
@RequestMapping("tOrder")
public class TOrderController {
    /**
     * 服务对象
     */
    @Resource
    private TOrderService tOrderService;

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("selectOne")
    public TOrder selectOne(int id) {
        return this.tOrderService.queryById(id);
    }

}