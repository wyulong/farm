package com.farm.interceptor;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.ObjectUtils;
import com.farm.annotation.OpenApi;
import com.farm.constants.CommonConstants;
import com.farm.constants.Errors;
import com.farm.dto.Result;
import com.farm.entity.User;
import com.farm.mapper.UserMapper;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.lang.reflect.Method;
import java.util.Date;

/**
 * @Author xhua
 * @Date 2020/3/22 12:29
 **/
public abstract class AbstractInterceptor implements HandlerInterceptor {

    @Resource
    private UserMapper userMapper;

    private static final ObjectMapper objectMapper = new ObjectMapper();

    /** 鉴权方法，由子类实现 **/
    protected abstract boolean doCheck(HttpServletRequest request, HttpServletResponse response) throws Exception;


    /**
     *  免登录
     * @param handler
     * @return
     */
    protected Boolean isOpenApi(Object handler){
        if (handler instanceof HandlerMethod){
            HandlerMethod handlerMethod = (HandlerMethod)handler;
            Method method = handlerMethod.getMethod();
            if (method.getAnnotation(OpenApi.class) != null){
                return true;
            }else if (method.getDeclaringClass().getAnnotation(OpenApi.class) != null){
                return true;
            }
        }
        return false;
    }

    /**
     *  验证token是否有效
     * @return
     */
    protected boolean verifyToken(){
        String token = SessionContext.getRemoteSid();
        User query = new User();
        query.setToken(token);
        User user = userMapper.selectOne(new QueryWrapper<>(query));
        if (ObjectUtils.isNotEmpty(user) && user.getTokenExpireTime().getTime() > System.currentTimeMillis()){
            //验证成功后刷新缓存时间
            user.setTokenExpireTime(new Date(System.currentTimeMillis() + CommonConstants.TOKEN_EXPIRE_TIME));
            userMapper.updateById(user);
            return true;
        }

        return false;
    }

}
