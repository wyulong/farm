package com.farm.service.impl;

import com.baomidou.mybatisplus.core.assist.ISqlRunner;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.farm.entity.User;
import com.farm.entity.UserRole;
import com.farm.interceptor.SessionContext;
import com.farm.mapper.UserMapper;
import com.farm.mapper.UserRoleMapper;
import com.farm.service.UserRoleService;
import com.farm.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;

/**
 * <p>
 * 角色权限表 服务实现类
 * </p>
 *
 * @author wyulong
 * @since 2020-03-27
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {


    @Resource
    private UserMapper userMapper;

    @Override
    public User currentUser() {
        User query = new User();
        query.setToken(SessionContext.getRemoteSid());
        return userMapper.selectOne(new QueryWrapper<>(query).gt("token_expire_time",new Date()));
    }
}
