package com.farm.configurations;

import com.farm.interceptor.AdminInterceptor;
import com.farm.interceptor.ContextInterceptor;
import com.farm.interceptor.TechInterceptor;
import com.farm.interceptor.UserInterceptor;
import com.farm.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import javax.annotation.Resource;

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
    private TechInterceptor techInterceptor;

    @Autowired
    private UserInterceptor userInterceptor;

    @Autowired
    private UserService userService;

    @Autowired
    private UploadConfiguration uploadConfiguration;

    /**
     *  添加拦截器，注意顺序
     * @param registry
     */
    @Override
    public void addInterceptors(InterceptorRegistry registry){
        //全局拦截器，初始化请求参数
        registry.addInterceptor(contextInterceptor).addPathPatterns("/**");
        //管理员请求拦截
        registry.addInterceptor(adminInterceptor).addPathPatterns("/admin/**");

        registry.addInterceptor(techInterceptor).addPathPatterns("/tech/**");

        registry.addInterceptor(userInterceptor).addPathPatterns("/user/**");
        // TODO 各个角色拦截器
    }

    /**
     *  资源路径映射
     * @param registry
     */
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/static/**").addResourceLocations("file:///" +uploadConfiguration.getFilePath());
    }

//    /**
//     *  跨域请求
//     * @param registry
//     */
//    @Override
//    public void addCorsMappings(CorsRegistry registry) {
//        registry.addMapping("/**")
//                .allowedHeaders("*")
//                .allowedOrigins("http://localhost:8080")
//                .allowedMethods("POST", "GET", "PUT", "OPTIONS", "DELETE")
//                .maxAge(3600)
//                .allowCredentials(true);
//    }

}
