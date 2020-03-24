package com.farm.service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.ObjectUtils;
import com.baomidou.mybatisplus.core.toolkit.StringUtils;
import com.farm.constants.ErrorResult;
import com.farm.dto.Result;
import com.farm.entity.User;
import com.farm.mapper.UserMapper;
import com.farm.util.MD5Util;
import com.farm.util.RegexUtil;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;
import java.util.UUID;

/**
 * @Author xhua
 * @Date 2020/3/24 16:03
 **/
@Service
public class AuthService {

    /** token过期时间 **/
    private final static int TOKEN_EXPIRE_TIME = 15 * 60 * 1000;

    @Resource
    private UserMapper userMapper;

    /**
     *  验证登录、创建token，更新会话过期时间
     * @param phone
     * @param password
     * @return
     */
    public Result<String> verifyPhoneAndPassword(String phone, String password){

        if (!RegexUtil.regexPhone(phone)){
            return Result.error("手机号格式错误");
        }

        if (StringUtils.isEmpty(phone) || StringUtils.isEmpty(password)){
            return Result.error("请输入账号密码");
        }
        //加密密码
        String encryptStr = MD5Util.encrypt(password);
        User query = new User();
        query.setPhone(phone);
        //检查账户是否存在
        User user = userMapper.selectOne(new QueryWrapper<>(query));
        if (ObjectUtils.isEmpty(user)){
            return Result.error("用户不存在");
        }else {
            User query1 = new User();
            query1.setPhone(phone);
            query1.setPassword(encryptStr);
            User user1 = userMapper.selectOne(new QueryWrapper<>(query1));
            if (ObjectUtils.isNotEmpty(user1)){
                String token = UUID.randomUUID().toString();
                user1.setToken(token);
                user1.setTokenExpireTime(new Date(System.currentTimeMillis() + TOKEN_EXPIRE_TIME));
                userMapper.updateById(user1);
                return Result.success(token);
            }else {
                return Result.error("密码错误");
            }
        }
    }

}
