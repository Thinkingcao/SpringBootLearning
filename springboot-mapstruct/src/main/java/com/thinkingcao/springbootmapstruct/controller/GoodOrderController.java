package com.thinkingcao.springbootmapstruct.controller;

import com.thinkingcao.springbootmapstruct.vo.GoodsOrderVo;
import com.thinkingcao.springbootmapstruct.entity.Good;
import com.thinkingcao.springbootmapstruct.entity.Order;
import com.thinkingcao.springbootmapstruct.inter.GoodOrderMapper;
import com.thinkingcao.springbootmapstruct.mapper.GoodsRepository;
import com.thinkingcao.springbootmapstruct.mapper.OrdersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

/**
 * <pre>
 * @desc: 商品-订单Controller
 * @author: cao_wencao
 * @date: 2019-11-04 23:16
 * @version: 1.0
 * </pre>
 */
@RestController
@RequestMapping("/goodOrder")
public class GoodOrderController {
    @Autowired
    private GoodsRepository goodsRepository;

    @Autowired
    private OrdersRepository ordersRepository;

    @Autowired
    private GoodOrderMapper goodOrderMapper;

    @RequestMapping(value = "/detail/{goodId}", method = RequestMethod.GET)
    public GoodsOrderVo details(@PathVariable(value = "goodId") Integer goodId) {

        Good goodInfo = goodsRepository.findById(goodId).get();

        Optional<Order> optionalT = ordersRepository.findById(goodId);

        Order order = optionalT.isPresent() ? optionalT.get() : null;
        
        return goodOrderMapper.fromGoodOrderDTO(goodInfo, order);
    }
}
