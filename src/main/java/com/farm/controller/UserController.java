package com.farm.controller;

import com.farm.annotation.OpenApi;
import com.farm.dto.Result;
import com.farm.entity.User;
import com.farm.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/** 普通用户接口
 * @Author xhua
 * @Date 2020/3/22 0:28
 **/
@RestController
@RequestMapping("/user")
@Slf4j
public class UserController {

    @Resource
    private UserService userService;

    @GetMapping("/get-user")
    public Result<User> getUser(@RequestParam("id")Integer id){
        return Result.success(userService.getUser(id));
    }

}
