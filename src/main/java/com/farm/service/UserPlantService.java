package com.farm.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.farm.entity.UserPlant;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 * 用户种植记录 服务类
 * </p>
 *
 * @author wyulong
 * @since 2020-03-27
 */
public interface UserPlantService extends IService<UserPlant> {

    IPage<UserPlant> getPlantInfo(int userId,long page,long pageSize);
}
