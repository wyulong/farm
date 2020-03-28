package com.farm.service.impl;

import com.farm.entity.Notice;
import com.farm.mapper.NoticeMapper;
import com.farm.service.NoticeService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 公告表 服务实现类
 * </p>
 *
 * @author wyulong
 * @since 2020-03-27
 */
@Service
public class NoticeServiceImpl extends ServiceImpl<NoticeMapper, Notice> implements NoticeService {

}
