package com.farm.service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.farm.constants.ApplyStatus;
import com.farm.constants.Enums;
import com.farm.dto.res.ApplyDTO;
import com.farm.entity.ApplyRecord;
import com.farm.mapper.ApplyRecordMapper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @Author xhua
 * @Date 2020/3/24 21:54
 **/
@Service
public class ApplyRecordService extends ServiceImpl<ApplyRecordMapper, ApplyRecord>{

    @Resource
    private ApplyRecordMapper applyRecordMapper;

    /**
     * 分页查询补贴
     *
     * @param currPage
     * @param pageSize
     * @return
     */
    public IPage<ApplyDTO> getApplyRecordPage(int userId, long currPage, long pageSize) {
        Page<ApplyDTO> page = new Page<>(currPage, pageSize);
        List<ApplyDTO> list = applyRecordMapper.listApply(page, userId);
        for (ApplyDTO applyDTO : list){
            ApplyStatus applyStatus = Enums.valueOf(applyDTO.getStatus(),ApplyStatus.class);
            applyDTO.setStatusDesc(applyStatus==null?null:applyStatus.getDesc());
        }
        return page.setRecords(list);
    }

}
