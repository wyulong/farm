package com.farm.helper.vo;

import java.io.Serializable;

/**
 * @Author xhua
 * @Date 2020/3/26 11:52
 **/
public class WechatH5AccessToken implements Serializable {

    private String accessToken;
    private String openId;
    /** 用作刷新token **/
    private String refreshToken;

    public String getAccessToken() {
        return accessToken;
    }

    public void setAccessToken(String accessToken) {
        this.accessToken = accessToken;
    }

    public String getOpenId() {
        return openId;
    }

    public void setOpenId(String openId) {
        this.openId = openId;
    }

    public String getRefreshToken() {
        return refreshToken;
    }

    public void setRefreshToken(String refreshToken) {
        this.refreshToken = refreshToken;
    }

    @Override
    public String toString() {
        return "WechatH5AccessToken{" +
                "accessToken='" + accessToken + '\'' +
                ", openId='" + openId + '\'' +
                ", refreshToken='" + refreshToken + '\'' +
                '}';
    }

}
