package com.farm.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.ObjectUtils;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.farm.entity.BusinessSumup;
import com.farm.entity.Notice;
import com.farm.service.BusinessSumupService;
import com.farm.service.NoticeService;
import com.farm.util.Exceptions;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * 管理员接口
 *
 * @Author xhua
 * @Date 2020/3/23 17:51
 **/
@RestController
@RequestMapping("/admin")
@Slf4j
public class AdminController {

    @Autowired
    private NoticeService noticeService;

    @Autowired
    private BusinessSumupService businessSumupService;

    /**
     * 测试接口
     *
     * @return
     */
    @GetMapping("/get")
    public String get() {
        return "123";
    }

    /**
     * 获取公告分页数据
     *
     * @param page     当前页
     * @param pageSize 每页数量
     * @return
     */
    @GetMapping("/notice")
    public IPage<Notice> getNoticePage(long page, long pageSize) {
        return noticeService.page(new Page<>(page, pageSize));
    }

    /**
     * 保存公告&修改公告
     *
     * @param notice 公告内容
     */
    @PostMapping("/notice")
    public void saveNotice(@RequestBody Notice notice) {
        notice.setStatus(1);
        noticeService.saveOrUpdate(notice);
    }

    /**
     * 删除公告
     *
     * @param id 公告id
     */
    @DeleteMapping("/notice/{id}")
    public void deleteNotice(@PathVariable Integer id) {
        Notice notice = noticeService.getById(id);
        if (ObjectUtils.isEmpty(notice)){
            Exceptions.throwss("公告不存在");
        }else {
            notice.setStatus(0);
            noticeService.saveOrUpdate(notice);
        }
    }

    /**
     * 获取公告详细信息
     *
     * @param id 公告id
     * @return
     */
    @GetMapping("/notice/{id}")
    public Notice getNotice(@PathVariable Integer id) {
        return noticeService.getById(id);
    }

    /**
     * 审批申请单
     */
    @PostMapping("/apply/resolve")
    public void resolveApplies() {
        //申请单id
        //审批状态
        //添加图片

    }

    /**
     *  保存&修改下乡总结
     * @param businessSumup
     */
    @PostMapping("/sumup")
    public void sumup(@RequestBody BusinessSumup businessSumup){
        businessSumup.setStatus(1);
        businessSumupService.saveOrUpdate(businessSumup);
    }

    /**
     *  撤回下乡总结
     * @param id
     */
    @DeleteMapping("/sumup/{id}")
    public void deleteSumup(@PathVariable("id")Integer id){
        BusinessSumup businessSumup = businessSumupService.getById(id);
        if (ObjectUtils.isEmpty(businessSumup)){
            Exceptions.throwss("总结不存在");
        }else {
            businessSumup.setStatus(0);
        }
    }


}
