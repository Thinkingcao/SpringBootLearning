package com.thinkingcao.springbootdatasource.entity;

import java.io.Serializable;

/**
 * (TOrder)实体类
 *
 * @author makejava
 * @since 2019-11-25 23:08:47
 */
public class TOrder implements Serializable {
    private static final long serialVersionUID = 863945675959198725L;
    /**
    * 订单编号
    */
    private String id;
    /**
    * 订单总价
    */
    private Object money;
    /**
    * 送货地址
    */
    private String receiveaddress;
    /**
    * 收货人姓名
    */
    private String receivename;
    /**
    * 收货人电话
    */
    private String receivephone;
    /**
    * 订单状态
    */
    private Integer paystate;
    /**
    * 下单时间
    */
    private Object ordertime;


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Object getMoney() {
        return money;
    }

    public void setMoney(Object money) {
        this.money = money;
    }

    public String getReceiveaddress() {
        return receiveaddress;
    }

    public void setReceiveaddress(String receiveaddress) {
        this.receiveaddress = receiveaddress;
    }

    public String getReceivename() {
        return receivename;
    }

    public void setReceivename(String receivename) {
        this.receivename = receivename;
    }

    public String getReceivephone() {
        return receivephone;
    }

    public void setReceivephone(String receivephone) {
        this.receivephone = receivephone;
    }

    public Integer getPaystate() {
        return paystate;
    }

    public void setPaystate(Integer paystate) {
        this.paystate = paystate;
    }

    public Object getOrdertime() {
        return ordertime;
    }

    public void setOrdertime(Object ordertime) {
        this.ordertime = ordertime;
    }

}