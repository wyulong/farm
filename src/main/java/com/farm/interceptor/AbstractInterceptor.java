package com.farm.interceptor;

import com.farm.annotation.OpenApi;
import com.farm.constants.ErrorResult;
import com.farm.dto.Result;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.lang.reflect.Method;

/**
 * @Author xhua
 * @Date 2020/3/22 12:29
 **/
public abstract class AbstractInterceptor implements HandlerInterceptor {

    private static final ObjectMapper objectMapper = new ObjectMapper();

    /** 鉴权方法，由子类实现 **/
    protected abstract boolean doCheck(HttpServletRequest request, HttpServletResponse response) throws Exception;

    /**
     *  快速响应失败
     * @param response
     * @param errorResult
     * @return
     * @throws Exception
     */
    protected boolean stopRequest(HttpServletResponse response, ErrorResult errorResult) throws Exception{
        response.setHeader("Content-Type", "application/json;charset=UTF-8");
        String json = objectMapper.writeValueAsString(Result.error(errorResult));
        response.getWriter().print(json);
        return false;
    }

    /**
     *  免登录
     * @param handler
     * @return
     */
    protected boolean isOpenApi(Object handler){
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

}
