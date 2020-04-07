package com.farm.service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.ObjectUtils;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.farm.constants.Enums;
import com.farm.constants.UserType;
import com.farm.dto.res.RoleModuleDTO;
import com.farm.entity.User;
import com.farm.interceptor.SessionContext;
import com.farm.mapper.UserMapper;
import com.farm.mapper.UserRoleMapper;
import com.farm.util.Exceptions;
import com.farm.util.RegexUtil;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;

/**
 * @Author xhua
 * @Date 2020/3/22 0:27
 **/
@Service
public class UserService extends ServiceImpl<UserMapper, User> {


    @Resource
    private UserMapper userMapper;

    @Resource
    private UserRoleMapper userRoleMapper;

    public User currentUser() {
        User query = new User();
        query.setToken(SessionContext.getRemoteSid());
        return userMapper.selectOne(new QueryWrapper<>(query).gt("token_expire_time",new Date()));
    }

    public void validUser(User user) {
        if (!Enums.isValid(user.getType(), UserType.class)){
            Exceptions.throwss("用户类型不合法");
        }
        if(!RegexUtil.regexPhone(user.getPhone())){
            Exceptions.throwss("手机号码格式不合法");
        }
        User query = User.builder().phone(user.getPhone()).build();
        User existUser = userMapper.selectOne(new QueryWrapper<>(query));
        if (ObjectUtils.isNotEmpty(existUser) && !existUser.getId().equals(user.getId())){
            Exceptions.throwss("号码已注册");
        }

        if(StringUtils.isBlank(user.getName())){
            Exceptions.throwss("用户名不合法");
        }
        if (!RegexUtil.validateCard(user.getCardId())){
            Exceptions.throwss("身份证号码不合法");
        }
    }

    public List<RoleModuleDTO> getMenu(Integer type) {
        return userRoleMapper.getMenuByUserType(type);
    }
}
