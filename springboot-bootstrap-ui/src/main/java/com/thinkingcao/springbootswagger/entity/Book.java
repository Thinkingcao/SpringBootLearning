package com.thinkingcao.springbootswagger.entity;

/**
 * <pre>
 * @desc: 图书实体类
 * @auth: cao_wencao
 * @date: 2019/11/26 20:27
 * </pre>
 */
public class Book {
    private long id;
    private String name;
    private double price;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}
