package com.farm.service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.farm.dto.Result;
import com.farm.entity.ApplyRecord;
import com.farm.mapper.ApplyRecordMapper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @Author xhua
 * @Date 2020/3/24 21:54
 **/
@Service
public class ApplyRecordService {

    @Resource
    private ApplyRecordMapper applyRecordMapper;

    /**
     *  查询补贴记录内容
     * @param id
     * @return
     */
    public Result getApplyRecord(Integer id) {
        return Result.success(applyRecordMapper.selectById(id));
    }

    /**
     * 分页查询补贴
     * @param currPage
     * @param pageSize
     * @return
     */
    public IPage<ApplyRecord> getApplyRecordPage(long currPage, long pageSize) {
        QueryWrapper<ApplyRecord> queryWrapper = new QueryWrapper<>();
        queryWrapper.orderByDesc("create_time");
        Page<ApplyRecord> page = new Page<>(currPage, pageSize);
        return applyRecordMapper.selectPage(page, queryWrapper);
    }

}
