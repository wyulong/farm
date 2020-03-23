package com.farm.service;

import com.farm.entity.User;
import com.farm.mapper.UserMapper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @Author xhua
 * @Date 2020/3/22 0:27
 **/
@Service
public class UserService {

    @Resource
    private UserMapper userMapper;

    public User getUser(Integer id){
        return userMapper.selectById(id);
    }

}
