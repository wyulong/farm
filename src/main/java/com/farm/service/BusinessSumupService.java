package com.farm.service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.farm.dto.res.BusinessSumupDTO;
import com.farm.entity.BusinessSumup;
import com.farm.entity.User;
import com.farm.mapper.BusinessSumupMapper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.stream.Collectors;

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

    @Resource
    private UserService userService;

    public IPage<BusinessSumupDTO> listSumup(Long page, Long pageSize) {
        return listSumup(null,page,pageSize);
    }


    public IPage<BusinessSumupDTO> listSumup(Integer userId,Long page, Long pageSize) {
        Page<BusinessSumup> ipage = new Page<>(page,pageSize);
        if (userId == null){
            Page<BusinessSumupDTO> tempPage = new Page<>(page,pageSize);
            List<BusinessSumupDTO> list = businessSumupMapper.listSumup(tempPage);
            return tempPage.setRecords(list);
        }
        User user = userService.getById(userId);
        BusinessSumup example = BusinessSumup.builder().authorId(userId).build();
        IPage<BusinessSumup> sumupIPage = businessSumupMapper.selectPage(ipage,new QueryWrapper<>(example));
        List<BusinessSumupDTO> dtoList = sumupIPage.getRecords().stream().map(sump -> {
            BusinessSumupDTO copy = copy(sump);
            copy.setAuthorName(user.getName());
            return copy;
        }).collect(Collectors.toList());

        IPage<BusinessSumupDTO> rsp = new Page<>(page,pageSize);
        rsp.setRecords(dtoList);
        rsp.setSize(sumupIPage.getSize());
        rsp.setTotal(sumupIPage.getTotal());
        rsp.setCurrent(sumupIPage.getCurrent());
        rsp.setPages(sumupIPage.getPages());
        return rsp;
    }

    public BusinessSumupDTO copy(BusinessSumup sumup,User user) {
        BusinessSumupDTO copy = copy(sumup);
        copy.setAuthorName(user.getName());
        return copy;
    }
    private BusinessSumupDTO copy(BusinessSumup sumup){
        BusinessSumupDTO businessSumupDTO = new BusinessSumupDTO();
        businessSumupDTO.setId(sumup.getId());
        businessSumupDTO.setAuthorId(sumup.getAuthorId());
        businessSumupDTO.setTitle(sumup.getTitle());
        businessSumupDTO.setTime(sumup.getTime());
        businessSumupDTO.setCoverImg(sumup.getCoverImg());
        businessSumupDTO.setContent(sumup.getContent());
        businessSumupDTO.setCreateTime(String.valueOf(sumup.getCreateTime()));
        return businessSumupDTO;
    }



    public BusinessSumupDTO sumupDetail(Integer id) {
        return businessSumupMapper.sumupDetail(id);
    }
}
