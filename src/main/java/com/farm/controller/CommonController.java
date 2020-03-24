package com.farm.controller;

import com.farm.annotation.OpenApi;
import com.farm.dto.Result;
import com.farm.dto.req.LoginInfoDTO;
import com.farm.interceptor.SessionContext;
import com.farm.service.AuthService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
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

    @Resource
    private AuthService authService;

    /**
     *  登录接口
     * @param loginInfoDTO
     * @return
     */
    @PostMapping("/login")
    @OpenApi
    public Result<String> login(@RequestBody LoginInfoDTO loginInfoDTO){
        return authService.verifyPhoneAndPassword(loginInfoDTO.getPhone(),loginInfoDTO.getPassword());
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
