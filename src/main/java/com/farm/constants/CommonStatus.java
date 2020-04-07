package com.farm.constants;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

/**
 * @Author xhua
 * @Date 2020/4/7 21:57
 **/
@AllArgsConstructor
@NoArgsConstructor
public enum CommonStatus {

    VALID(1,"有效"),
    INVALID(1,"无效");

    private Integer code;
    private String desc;

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }


}
