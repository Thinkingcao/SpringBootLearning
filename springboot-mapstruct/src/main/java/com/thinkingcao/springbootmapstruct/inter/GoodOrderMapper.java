package com.thinkingcao.springbootmapstruct.inter;

import com.thinkingcao.springbootmapstruct.vo.GoodsOrderVo;
import com.thinkingcao.springbootmapstruct.entity.Good;
import com.thinkingcao.springbootmapstruct.entity.Order;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

@Mapper(componentModel = "spring")
public interface GoodOrderMapper {
    @Mappings({
            @Mapping(source = "order.orderId", target = "orderId"),
            @Mapping(source = "order.orderMoney", target = "orderMoney"),
            @Mapping(source = "order.payState", target = "payState"),
            @Mapping(source = "good.goodType", target = "goodType"),
            @Mapping(source = "good.goodName",target = "goodName")
    })
    GoodsOrderVo fromGoodOrderDTO(Good good, Order order);
}