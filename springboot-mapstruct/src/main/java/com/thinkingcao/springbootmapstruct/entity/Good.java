package com.thinkingcao.springbootmapstruct.entity;

import lombok.Data;

import javax.persistence.*;

/**
 * <pre>
 * @desc: 商品表 
 * @author: cao_wencao
 * @date: 2019-11-04 22:36
 * @version: 1.0
 * </pre>
 */
@Entity
@Table(name="t_good")
@Data
public class Good {
    @Id
    @Column(name ="good_id",columnDefinition = "int(100) COMMENT '商品编号id'")
    @GeneratedValue(strategy = GenerationType.AUTO)       //主键自动增长
    private int goodId;
    
    @Column(name = "good_type",columnDefinition = "varchar(100) COMMENT '商品类别'")
    private String goodType;

    @Column(name = "good_name",columnDefinition = "varchar(100) COMMENT '商品名称'")
    private String goodName;

    @Column(name = "good_num",columnDefinition = "int(100) COMMENT '商品数量'")
    private int goodNum;

    @Column(name = "good_price",columnDefinition = "int(100) COMMENT '商品价格'")
    private int goodPrice;
}
