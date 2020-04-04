package com.farm.constants;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public enum ArticleType implements Enums {

    NOTICE(1,"公告"),
    PLANT(2,"栽培方法"),
    BUG(3,"病虫防治");

    private int code;
    private String desc;

    public int getCode() {
        return code;
    }

    public String getDesc() {
        return desc;
    }
}
