package com.farm.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.farm.entity.UserCollect;
import com.farm.mapper.UserCollectMapper;
import com.farm.service.UserCollectService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * <p>
 * 用户收藏 服务实现类
 * </p>
 *
 * @author wyulong
 * @since 2020-03-27
 */
@Service
public class UserCollectServiceImpl extends ServiceImpl<UserCollectMapper, UserCollect> implements UserCollectService {


    @Resource
    private UserCollectMapper collectMapper;

    @Override
    public boolean exists(Integer userId, Integer articleId) {
        Integer count = collectMapper.selectCount(new QueryWrapper<>(UserCollect.builder().articleId(articleId).userId(userId).build()));
        return count > 0;
    }
}
