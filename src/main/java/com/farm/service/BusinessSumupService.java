package com.farm.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.farm.dto.res.BusinessSumupDTO;
import com.farm.entity.BusinessSumup;
import com.baomidou.mybatisplus.extension.service.IService;
import com.farm.mapper.BusinessSumupMapper;
import org.springframework.stereotype.Service;
import sun.dc.pr.PRError;

import javax.annotation.Resource;
import java.util.List;

/**
 * <p>
 * 下乡总计表 服务类
 * </p>
 *
 * @author wyulong
 * @since 2020-03-27
 */
@Service
public class BusinessSumupService extends ServiceImpl<BusinessSumupMapper, BusinessSumup>{

    @Resource
    private BusinessSumupMapper businessSumupMapper;

    public IPage<BusinessSumupDTO> listSumup(Long page, Long pageSize) {
        Page<BusinessSumupDTO> ipage = new Page<>(page,pageSize);
        List<BusinessSumupDTO> list = businessSumupMapper.listSumup(ipage);
        return ipage.setRecords(list);
    }

    public BusinessSumupDTO sumupDetail(Integer id) {
        return businessSumupMapper.sumupDetail(id);
    }
}
