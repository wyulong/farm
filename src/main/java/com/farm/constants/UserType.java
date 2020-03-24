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
    MANAGE(2,"技术人员"),
    GENERAL_USER(3,"普通用户");

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

    public static UserType getUserTypeByCode(int code){
        for (UserType userType:UserType.values()){
            if (userType.getCode() == code){
                return userType;
            }
        }
        return null;
    }

}
