package com.farm.service;

import com.alibaba.fastjson.JSON;
import com.farm.Application;
import com.farm.dto.Result;
import com.farm.entity.ApplyRecord;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;

/**
 * @Author xhua
 * @Date 2020/3/24 9:45
 **/
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = Application.class)
public class ApplyRecordTest {

    @Resource
    private ApplyRecordService applyRecordService;

    @Test
    public void test() {
        ApplyRecord result = applyRecordService.getById(1);
        System.out.println(JSON.toJSONString(result));

    }

}
