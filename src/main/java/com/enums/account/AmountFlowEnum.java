package com.enums.account;

import com.enums.DescedEnum;
import com.enums.NumbericEnum;

public enum AmountFlowEnum implements DescedEnum, NumbericEnum {


    PLUS(1,"加"),

    MINUS(0,"减");

    private Integer value;
    private String desc;

    AmountFlowEnum(Integer value, String desc) {
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
