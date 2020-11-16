package com.example.japidocs.entity;

import java.io.Serializable;

/**
 * (TOrder)实体类
 *
 * @author makejava
 * @since 2020-11-12 14:30:20
 */
public class Order implements Serializable {
    private static final long serialVersionUID = -19230576305027662L;
    /**
    * 订单ID
    */
    private Integer oid;
    /**
    * 购买数量
    */
    private Integer number;
    /**
    * 商品ID
    */
    private Integer pid;
    /**
    * 商品名称
    */
    private String pname;
    /**
    * 商品单价
    */
    private Double pprice;
    /**
    * 用户ID
    */
    private Integer uid;

    /**
     * 用户名
     */
    private String username;


    public Integer getOid() {
        return oid;
    }

    public void setOid(Integer oid) {
        this.oid = oid;
    }

    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }

    public Integer getPid() {
        return pid;
    }

    public void setPid(Integer pid) {
        this.pid = pid;
    }

    public String getPname() {
        return pname;
    }

    public void setPname(String pname) {
        this.pname = pname;
    }

    public Double getPprice() {
        return pprice;
    }

    public void setPprice(Double pprice) {
        this.pprice = pprice;
    }

    public Integer getUid() {
        return uid;
    }

    public void setUid(Integer uid) {
        this.uid = uid;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

}