package com.farm.service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import com.farm.dto.Result;
import com.farm.entity.ApplyRecord;
import com.farm.entity.Article;
import com.farm.mapper.ApplyRecordMapper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @Author xhua
 * @Date 2020/3/24 21:54
 **/
@Service
public interface ApplyRecordService extends IService<ApplyRecord> {

    /**
     * 分页查询补贴
     *
     * @param currPage
     * @param pageSize
     * @return
     */
    IPage<ApplyRecord> getApplyRecordPage(long currPage, long pageSize);


}
