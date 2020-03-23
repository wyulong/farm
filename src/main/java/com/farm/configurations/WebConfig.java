package com.farm.configurations;

import com.farm.interceptor.AdminInterceptor;
import com.farm.interceptor.ContextInterceptor;
import com.farm.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**  Web 权限控制
 * @Author xhua
 * @Date 2020/3/22 1:10
 **/
@Configuration
@Slf4j
public class WebConfig implements WebMvcConfigurer {

    @Autowired
    private ContextInterceptor contextInterceptor;

    @Autowired
    private AdminInterceptor adminInterceptor;

    @Autowired
    private UserService userService;

    /**
     *  添加拦截器，注意顺序
     * @param registry
     */
    @Override
    public void addInterceptors(InterceptorRegistry registry){
        //全局拦截器，初始化请求参数
        registry.addInterceptor(contextInterceptor).addPathPatterns("/**");
        //管理员请求拦截
        registry.addInterceptor(adminInterceptor).addPathPatterns("/admin/*");
        // TODO 各个角色拦截器
    }

}
