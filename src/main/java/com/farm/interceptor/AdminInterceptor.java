package com.farm.interceptor;

import com.farm.constants.ErrorResult;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**  超级管理员拦截器
 * @Author xhua
 * @Date 2020/3/22 14:11
 **/
@Component
public class AdminInterceptor extends AbstractInterceptor{

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {

        // 是否免登录校验
        if ( super.isOpenApi(handler) ) {
            return true;
        }

        return doCheck(request,response);
    }

    /**
     *  鉴权逻辑
     * @param request
     * @param response
     * @return
     */
    @Override
    protected boolean doCheck(HttpServletRequest request, HttpServletResponse response) throws Exception{
        if (SessionContext.getRemoteSid() == null){
            return stopRequest(response,ErrorResult.ILLEGAL_PARAMS);
        }else {
            //TODO  token检查
            return true;
        }
    }
}
