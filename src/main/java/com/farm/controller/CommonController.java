package com.farm.controller;

import com.farm.annotation.OpenApi;
import com.farm.dto.Result;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author xhua
 * @Date 2020/3/23 14:39
 **/
@RestController
@RequestMapping("/common")
public class CommonController {

    @RequestMapping("/login")
    @OpenApi
    public Result<String> login(){
        return Result.success();
    }
}
