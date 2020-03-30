package com.farm.constants;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

/**
 * @Author xhua
 * @Date 2020/3/22 0:43
 **/
@AllArgsConstructor
public enum UserType implements Enums{

    ADMIN(1,"超级管理员"),
    MANAGE(2,"技术人员"),
    GENERAL_USER(3,"普通用户");

    private int code;
    private String desc;

    public int getCode() {
        return code;
    }

    public String getDesc() {
        return desc;
    }

}
