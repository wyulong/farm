package com.farm.helper;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.farm.helper.vo.WechatBaseInfo;
import com.farm.helper.vo.WechatH5AccessToken;
import com.farm.util.HttpUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/** 微信认证相关
 * @Author xhua
 * @Date 2020/3/26 14:55
 **/
public class WechatAuthHelper {

    private static final Logger logger = LoggerFactory.getLogger(WechatAuthHelper.class);

    /** 公众号网页accessToken **/
    private static final String GZH_H5_ACCESS_TOKEN = "https://api.weixin.qq.com/sns/oauth2/access_token?appid=%s&secret=%s&code=%s&grant_type=authorization_code";

    /** 公众号H5页授权获取用户信息 **/
    private static final String GZH_H5_USER_INFO = "https://api.weixin.qq.com/sns/userinfo?access_token=%s&openid=%s&lang=zh_CN";

    private static String gzhH5UserInfo(String accessToken,String openId){
        return String.format(GZH_H5_USER_INFO,accessToken,openId);
    }

    private static String gzhH5AccessToken(String appId, String appSecret,String code){
        return String.format(GZH_H5_ACCESS_TOKEN,appId,appSecret,code);
    }

    /**
     *  网页授权
     * @param appId
     * @param appSecret
     * @param code
     * @return
     */
    public static WechatH5AccessToken getWechatH5AccessToken(String appId, String appSecret,String code){
        String url = gzhH5AccessToken(appId, appSecret, code);
        String response = HttpUtil.get(url);
        if (response != null ){
            logger.debug("get access token -> url : {} , response : {}", url, response);
            JSONObject jsonObject = JSON.parseObject(response);
            // code 过期
            if (jsonObject.containsKey("access_token")){
                WechatH5AccessToken wechatH5AccessToken = new WechatH5AccessToken();
                wechatH5AccessToken.setAccessToken(jsonObject.getString("access_token"));
                //用作刷新token
                wechatH5AccessToken.setRefreshToken(jsonObject.getString("refresh_token"));
                wechatH5AccessToken.setOpenId(jsonObject.getString("openid"));
                return wechatH5AccessToken;
            }else {
                logger.info("h5 code expire");
                return null;
            }
        }else {
            logger.error("get h5 accessToken fail");
            return null;
        }
    }

    /**
     *  网页有感授权获取用户信息
     * @param accessToken
     * @param openId
     * @return
     */
    public static WechatBaseInfo getGzhH5UserInfo(String accessToken, String openId){
        String url = gzhH5UserInfo(accessToken, openId);
        String response = HttpUtil.get(url,"UTF-8");
        if (response != null){
            logger.debug("get h5 userInfo -> url : {} , response : {}", url, response);
            JSONObject jsonObject = JSON.parseObject(response);
            if (jsonObject.containsKey("openid")){
                WechatBaseInfo wechatBaseInfo = new WechatBaseInfo();
                wechatBaseInfo.setOpenid(openId);
                wechatBaseInfo.setSex(jsonObject.getInteger("sex"));
                wechatBaseInfo.setNickname(jsonObject.getString("nickname"));
                wechatBaseInfo.setProvince(jsonObject.getString("province"));
                wechatBaseInfo.setHeadimgurl(jsonObject.getString("headimgurl"));
                wechatBaseInfo.setCountry(jsonObject.getString("country"));
                wechatBaseInfo.setCity(jsonObject.getString("city"));
                wechatBaseInfo.setUnionid(jsonObject.getString("unionid"));
                return wechatBaseInfo;
            }else {
                logger.info("invalid openid");
                return null;
            }
        }else {
            logger.error("get h5 userInfo fail");
            return null;
        }
    }

}
