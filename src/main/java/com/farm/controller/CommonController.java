package com.farm.controller;

import com.farm.annotation.OpenApi;
import com.farm.dto.Result;
import com.farm.interceptor.SessionContext;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**  通用接口，登录、评论、收藏、搜索功能
 *  不做权限拦截
 * @Author xhua
 * @Date 2020/3/23 14:39
 **/
@RestController
@RequestMapping("/common")
@Slf4j
public class CommonController {

    /**
     *  登录接口
     * @param phone
     * @param password
     * @return
     */
    @PostMapping("/login")
    @OpenApi
    public Result<String> login(@RequestParam("phone")String phone,@RequestParam("password")String password){
        String sid = SessionContext.getRemoteSid();
        System.out.println(sid);
        System.out.println(phone + "--" + password);
        //TODO 登录鉴权
        return Result.success();
    }

    /**
     *   菜单权限接口
     */
    @GetMapping("/menu")
    public Result<List> menu(){
        //TODO 根据角色返回角色权限
        return Result.success();
    }

}
