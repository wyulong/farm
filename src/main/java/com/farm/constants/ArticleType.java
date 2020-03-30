package com.farm.constants;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public enum ArticleType implements Enums {
    PLANT(1,"栽培方法"),
    BUG(2,"病虫防治");

    private int code;
    private String desc;

    public int getCode() {
        return code;
    }

    public String getDesc() {
        return desc;
    }
}
