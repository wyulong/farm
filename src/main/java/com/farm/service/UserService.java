package com.farm.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.farm.entity.User;
import com.farm.entity.UserRole;
import com.farm.mapper.UserMapper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @Author xhua
 * @Date 2020/3/22 0:27
 **/
@Service
public interface UserService extends IService<User> {



}
