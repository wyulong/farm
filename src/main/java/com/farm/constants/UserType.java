package com.farm.constants;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

/**
 * @Author xhua
 * @Date 2020/3/22 0:43
 **/
@AllArgsConstructor
@NoArgsConstructor
public enum UserType {

    ADMIN(1,"超级管理员"),
    MANAGE(2,"管理员");

    private int code;
    private String desc;

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

}
