package com.farm.controller;

import com.farm.entity.Comment;
import com.farm.entity.User;
import com.farm.service.CommentService;
import com.farm.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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

    @Autowired
    private CommentService commentService;

    @GetMapping("/get-user")
    public User getUser(@RequestParam("id")Integer id){
        return userService.getById(id);
    }

    @PostMapping("/add-comment")
    public void addComment(@RequestBody Comment comment){
        commentService.saveOrUpdate(comment);
    }

}
