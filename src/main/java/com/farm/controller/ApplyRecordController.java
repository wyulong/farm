package com.farm.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.farm.entity.ApplyRecord;
import com.farm.service.ApplyRecordService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Date;

@RestController
@RequestMapping("/applys")
@Slf4j
public class ApplyRecordController {


    @Autowired
    private ApplyRecordService applyRecordService;



    @GetMapping("/{id}")
    public ApplyRecord getRecord(@PathVariable Integer id) {
        return applyRecordService.getById(id);
    }

    @GetMapping
    public IPage<ApplyRecord> getApplyRecordPage(@RequestParam Integer page, @RequestParam Integer pageSize) {
        return applyRecordService.getApplyRecordPage(page, pageSize);
    }

    @PostMapping
    public void save(@RequestBody ApplyRecord applyRecord) {
        applyRecord.setCreateTime(new Date());
        applyRecord.setUpdateTime(new Date());
        applyRecordService.save(applyRecord);
    }

    @PutMapping
    public void update(@RequestBody ApplyRecord applyRecord) {
        applyRecord.setUpdateTime(new Date());
        applyRecordService.updateById(applyRecord);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Integer id) {
        applyRecordService.removeById(id);
    }

}
