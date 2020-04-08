package com.farm.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.farm.dto.res.ApplyDTO;
import com.farm.entity.ApplyRecord;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @Author xhua
 * @Date 2020/3/24 21:48
 **/
public interface ApplyRecordMapper extends BaseMapper<ApplyRecord> {

    List<ApplyDTO> listApply(Page<ApplyDTO> page, @Param("userId") int userId);

}
