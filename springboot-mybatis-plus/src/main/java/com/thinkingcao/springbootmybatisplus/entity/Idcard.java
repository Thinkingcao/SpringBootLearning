package com.thinkingcao.springbootmybatisplus.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import java.io.Serializable;

/**
 * <pre>
 * @desc: Idcard实体类
 * @author: cao_wencao
 * @date: 2019-08-21 17:37
 * @version: 1.0
 * </pre>
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName("t_idcard")
@ApiModel(value="Idcard对象", description="")
public class Idcard extends Model<Idcard> {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "主键id")
    @TableId(value = "id", type = IdType.ID_WORKER)
    @JsonSerialize(using= ToStringSerializer.class)
    private Long id;

    @ApiModelProperty(value = "身份证号码")
    private String code;


    public static final String ID = "id";

    public static final String CODE = "code";

    @Override
    protected Serializable pkVal() {
        return this.id;
    }

}
