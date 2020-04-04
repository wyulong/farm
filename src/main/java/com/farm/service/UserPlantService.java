package com.farm.service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.farm.entity.UserPlant;
import com.baomidou.mybatisplus.extension.service.IService;
import com.farm.mapper.UserPlantMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * <p>
 * 用户种植记录 服务类
 * </p>
 *
 * @author wyulong
 * @since 2020-03-27
 */
@Service
public class UserPlantService extends ServiceImpl<UserPlantMapper, UserPlant>{

    @Resource
    private UserPlantMapper userPlantMapper;

    public IPage<UserPlant> getPlantInfo(int userId, long page, long pageSize) {
        UserPlant userPlant = UserPlant.builder().userId(userId).build();
        return userPlantMapper.selectPage(new Page<>(page, pageSize),new QueryWrapper<>(userPlant));
    }
}
