package com.farm.service;

import com.alibaba.fastjson.JSON;
import com.farm.Application;
import com.farm.entity.User;
import com.farm.util.MD5Util;
import com.farm.util.RegexUtil;
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
public class UserServiceTest {

    @Resource
    private UserService userService;

    @Test
    public void test(){

        User user = userService.getUser(1);
        System.out.println(JSON.toJSONString(user));

        String encryptStr = MD5Util.encrypt("123456");
        System.out.println(encryptStr);

        boolean isPhone = RegexUtil.regexPhone("13786272773");
        System.out.println(isPhone);


    }

}
