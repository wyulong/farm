package com.farm.constants;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public enum  ApplyStatus implements Enums {

    APPLY(1,"申请中"),

    REJECTED(2,"拒绝"),

    PASS(3,"通过");

    private int code;
    private String desc;

    public int getCode() {
        return code;
    }

    public String getDesc() {
        return desc;
    }
}
