package com.enums;

/**
 * 通用状态
 */
public enum StatusEnum implements DescedEnum, NumbericEnum{


    NORMAL(1,"正常"),

    ABNORMAL(2,"非正常");


    private Integer value;
    private String desc;

    StatusEnum(Integer value, String desc) {
        this.value = value;
        this.desc = desc;
    }

    @Override
    public int toNumbericValue() {
        return value;
    }

    @Override
    public String desc() {
        return desc;
    }
}
