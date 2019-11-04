package com.thinkingcao.springbootmapstruct.vo;

import lombok.Data;

/**
 * <pre>
 * @desc: 商品订单（DTO数据传输对象）
 * @author: cao_wencao
 * @date: 2019-11-04 23:05
 * @version: 1.0
 * </pre>
 */
@Data
public class GoodsOrderVo {

    private int orderId;    //订单编号ID

    private int orderMoney; //订单金额

    private int payState; //支付状态

    private String goodType; //商品类别

    private String goodName; //商品名称
}
