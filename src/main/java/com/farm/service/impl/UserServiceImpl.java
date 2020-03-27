package com.farm.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.farm.entity.User;
import com.farm.entity.UserRole;
import com.farm.mapper.UserMapper;
import com.farm.mapper.UserRoleMapper;
import com.farm.service.UserRoleService;
import com.farm.service.UserService;
import org.springframework.stereotype.Service;

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

}
