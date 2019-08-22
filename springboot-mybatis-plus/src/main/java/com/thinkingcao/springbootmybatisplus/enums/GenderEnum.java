package com.thinkingcao.springbootmybatisplus.enums;

import com.baomidou.mybatisplus.core.enums.IEnum;
import com.fasterxml.jackson.annotation.JsonValue;

/**
 * <pre>
 * @desc:  性别枚举类定义
 * @author: cao_wencao
 * @date: 2019-08-21 17:39
 * @version: 1.0
 * </pre>
 */
public enum GenderEnum implements IEnum<Integer> {

    SECRECY(0, "保密"),
    MALE(1, "男"),
    FEMALE(2, "女"),
    UNKNOWN(3, "未知");

    private Integer value;
    private String desc;

    GenderEnum(Integer value, String desc) {
        this.value = value;
        this.desc = desc;
    }


    /**
     * 通过value获取enum
     *
     * @param value enum-value
     * @return enum
     */
    public static GenderEnum getEnumByValue(Integer value) {
        for (GenderEnum obj : GenderEnum.values())
            if (obj.value.equals(value)) {
                return obj;
            }

        // 没有找到
        return GenderEnum.UNKNOWN;
    }

    public static GenderEnum getEnumByDesc(String desc) {
        for (GenderEnum obj : GenderEnum.values()) {
            if (obj.desc.equals(desc)) {
                return obj;
            }
        }

        // 没有找到
        return GenderEnum.UNKNOWN;
    }

    @Override
    public Integer getValue() {
        return this.value;
    }

    @JsonValue
    public String getDesc() {
        return desc;
    }
}

