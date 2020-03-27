package com.farm.service;

import com.farm.entity.UserCollect;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 * 用户收藏 服务类
 * </p>
 *
 * @author wyulong
 * @since 2020-03-27
 */
public interface UserCollectService extends IService<UserCollect> {

    /**
     * 是否存在收藏
     * @param userId
     * @param articleId
     * @return
     */
    boolean exists(Integer userId,Integer articleId);

}
