package com.farm.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.farm.entity.ApplyRecord;
import com.farm.mapper.ApplyRecordMapper;
import com.farm.service.ApplyRecordService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @Author xhua
 * @Date 2020/3/24 21:54
 **/
@Service
public class ApplyRecordServiceImpl extends ServiceImpl<ApplyRecordMapper, ApplyRecord> implements ApplyRecordService {

    @Resource
    private ApplyRecordMapper applyRecordMapper;

    @Override
    public IPage<ApplyRecord> getApplyRecordPage(long currPage, long pageSize) {
        QueryWrapper<ApplyRecord> queryWrapper = new QueryWrapper<>();
        queryWrapper.orderByDesc("create_time");
        Page<ApplyRecord> page = new Page<>(currPage, pageSize);
        return applyRecordMapper.selectPage(page, queryWrapper);
    }

}
