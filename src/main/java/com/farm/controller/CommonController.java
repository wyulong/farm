package com.farm.controller;

import com.farm.annotation.OpenApi;
import com.farm.dto.Result;
import com.farm.dto.req.LoginParamsDTO;
import com.farm.dto.req.RegisterDTO;
import com.farm.dto.res.LoginInfoDTO;
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
     *  注册接口
     * @param registerDTO
     * @return
     */
    @PostMapping("/register")
    public Result<Boolean> register(@RequestBody RegisterDTO registerDTO){
        return authService.register(registerDTO);
    }

    /**
     *  登录接口
     * @param loginParamsDTO
     * @return
     */
    @PostMapping("/login")
    @OpenApi
    public Result<LoginInfoDTO> login(@RequestBody LoginParamsDTO loginParamsDTO){
        return authService.verifyPhoneAndPassword(loginParamsDTO.getPhone(), loginParamsDTO.getPassword());
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
