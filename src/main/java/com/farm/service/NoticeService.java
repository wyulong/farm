package com.farm.service;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.farm.entity.Notice;
import com.baomidou.mybatisplus.extension.service.IService;
import com.farm.mapper.NoticeMapper;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 公告表 服务类
 * </p>
 *
 * @author wyulong
 * @since 2020-03-27
 */
@Service
public class NoticeService extends ServiceImpl<NoticeMapper, Notice>{

}
