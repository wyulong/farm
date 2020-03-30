package com.farm.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.farm.entity.UserPlant;
import com.farm.mapper.UserPlantMapper;
import com.farm.service.UserPlantService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 用户种植记录 服务实现类
 * </p>
 *
 * @author wyulong
 * @since 2020-03-27
 */
@Service
public class UserPlantServiceImpl extends ServiceImpl<UserPlantMapper, UserPlant> implements UserPlantService {

    @Autowired
    private UserPlantMapper userPlantMapper;

    @Override
    public IPage<UserPlant> getPlantInfo(int userId, long page, long pageSize) {
        UserPlant userPlant = UserPlant.builder().userId(userId).build();
        return userPlantMapper.selectPage(new Page<>(page, pageSize),new QueryWrapper<>(userPlant));
    }
}
