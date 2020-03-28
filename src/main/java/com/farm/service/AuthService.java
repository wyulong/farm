package com.farm.service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.ObjectUtils;
import com.baomidou.mybatisplus.core.toolkit.StringUtils;
import com.farm.constants.UserType;
import com.farm.dto.req.RegisterDTO;
import com.farm.dto.res.LoginInfoDTO;
import com.farm.entity.User;
import com.farm.mapper.UserMapper;
import com.farm.util.Exceptions;
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

    /**
     * token过期时间
     **/
    private final static int TOKEN_EXPIRE_TIME = 15 * 60 * 1000;

    @Resource
    private UserMapper userMapper;

    /**
     * 验证登录、创建token，更新会话过期时间
     *
     * @param phone
     * @param password
     * @return
     */
    public LoginInfoDTO verifyPhoneAndPassword(String phone, String password) {

        if (!RegexUtil.regexPhone(phone)) {
            Exceptions.throwss("手机号格式错误");
        }

        if (StringUtils.isEmpty(phone) || StringUtils.isEmpty(password)) {
            Exceptions.throwss("请输入账号密码");
        }
        //加密密码
        String encryptStr = MD5Util.encrypt(password);
        User query = new User();
        query.setPhone(phone);
        //检查账户是否存在
        User user = userMapper.selectOne(new QueryWrapper<>(query));
        if (ObjectUtils.isEmpty(user)) {
            Exceptions.throwss("用户不存在");
        }

        User query1 = new User();
        query1.setPhone(phone);
        query1.setPassword(encryptStr);
        User user1 = userMapper.selectOne(new QueryWrapper<>(query1));
        if (ObjectUtils.isEmpty(user1)) {
            Exceptions.throwss("密码错误");
        }
        String token = UUID.randomUUID().toString();
        user1.setToken(token);
        user1.setTokenExpireTime(new Date(System.currentTimeMillis() + TOKEN_EXPIRE_TIME));
        userMapper.updateById(user1);

        UserType userType = UserType.getUserTypeByCode(user1.getType());
        LoginInfoDTO loginInfoDTO = LoginInfoDTO.builder().
                token(token).
                userType(user1.getType()).
                roleDesc(userType == null ? "未知" : userType.getDesc()).
                build();

        return loginInfoDTO;

    }

    /**
     * 注册逻辑
     *
     * @param registerDTO
     * @return
     */
    public boolean register(RegisterDTO registerDTO) {

        if (!RegexUtil.regexPhone(registerDTO.getPhone())) {
            Exceptions.throwss("手机号格式错误");
        }

        if (!RegexUtil.validateCard(registerDTO.getCardId())) {
            Exceptions.throwss("错误的身份证号");
        }

        User query = User.builder().phone(registerDTO.getPhone()).build();
        User existUser = userMapper.selectOne(new QueryWrapper<>(query));
        if (ObjectUtils.isNotEmpty(existUser)){
            Exceptions.throwss("号码已注册");
        }

        User user = User.builder().
                name(registerDTO.getName()).
                password(MD5Util.encrypt(registerDTO.getPassword())).
                phone(registerDTO.getPhone()).
                cardId(registerDTO.getCardId()).
                type(UserType.GENERAL_USER.getCode()).
                createTime(new Date()).
                build();

        int res = userMapper.insert(user);

        return res > 0 ;
    }

}
