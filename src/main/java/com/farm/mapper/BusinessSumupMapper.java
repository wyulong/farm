package com.farm.mapper;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.farm.dto.res.BusinessSumupDTO;
import com.farm.entity.BusinessSumup;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * <p>
 * 下乡总计表 Mapper 接口
 * </p>
 *
 * @author wyulong
 * @since 2020-03-27
 */
public interface BusinessSumupMapper extends BaseMapper<BusinessSumup> {

    List<BusinessSumupDTO> listSumup(Page<BusinessSumupDTO> ipage);

    BusinessSumupDTO sumupDetail(@Param("id") Integer id);
}
