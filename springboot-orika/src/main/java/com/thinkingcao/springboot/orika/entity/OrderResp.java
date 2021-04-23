package com.thinkingcao.springboot.orika.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.Date;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class OrderResp {

    private String orderId;

    private String orderName;

    private BigDecimal orderMoney;

    private Date orderTime;

    private String orderAddress;
}
