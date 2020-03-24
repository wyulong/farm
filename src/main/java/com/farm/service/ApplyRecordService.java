package com.farm.service;

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
    public Result<ApplyRecord> getApplyRecord(Integer id){
        return Result.success(applyRecordMapper.selectById(id));
    }
}
