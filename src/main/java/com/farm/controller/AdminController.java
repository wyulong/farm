package com.farm.controller;

import com.farm.dto.Result;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/** 管理员接口
 * @Author xhua
 * @Date 2020/3/23 17:51
 **/
@RestController
@RequestMapping("/admin")
@Slf4j
public class AdminController {

    @GetMapping("/get")
    public Result<String> get(){
        return Result.success("123");
    }
}
