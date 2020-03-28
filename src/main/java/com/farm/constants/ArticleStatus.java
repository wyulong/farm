package com.farm.constants;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

/**
 * @Author xhua
 * @Date 2020/3/28 14:30
 **/
@AllArgsConstructor
@NoArgsConstructor
public enum ArticleStatus {

    VALID(1,"有效的"),
    INVALID(0,"无效的");

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
