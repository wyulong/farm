package com.farm.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.farm.dto.Result;
import com.farm.entity.ApplyRecord;
import com.farm.mapper.ApplyRecordMapper;
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

    @Autowired
    private ApplyRecordMapper applyRecordMapper;

    @GetMapping("/{id}")
    public ApplyRecord getRecord(@PathVariable Integer id) {
        return applyRecordMapper.selectById(id);
    }

    @GetMapping
    public IPage<ApplyRecord> getApplyRecordPage(@RequestParam Integer page, @RequestParam Integer pageSize) {
        return applyRecordService.getApplyRecordPage(page, pageSize);
    }

    @PostMapping
    public void save(@RequestBody ApplyRecord applyRecord) {
        applyRecord.setCreateTime(new Date());
        applyRecord.setUpdateTime(new Date());
        applyRecordMapper.insert(applyRecord);
    }

    @PutMapping
    public void update(@RequestBody ApplyRecord applyRecord) {
        applyRecord.setUpdateTime(new Date());
        applyRecordMapper.updateById(applyRecord);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Integer id) {
        applyRecordMapper.deleteById(id);
    }

}
