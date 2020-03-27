package com.farm.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.farm.entity.Notice;
import com.farm.service.NoticeService;
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
        noticeService.saveOrUpdate(notice);
    }

    /**
     * 删除公告
     *
     * @param id 公告id
     */
    @DeleteMapping("/notice/{id}")
    public void deleteNotice(@PathVariable Integer id) {
        noticeService.removeById(id);
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


}
