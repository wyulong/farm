package com.farm.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.ObjectUtils;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.farm.constants.Errors;
import com.farm.dto.req.RegisterDTO;
import com.farm.entity.BusinessSumup;
import com.farm.entity.Notice;
import com.farm.entity.User;
import com.farm.service.AuthService;
import com.farm.service.BusinessSumupService;
import com.farm.service.NoticeService;
import com.farm.service.UserService;
import com.farm.util.Exceptions;
import com.farm.util.MD5Util;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.Optional;

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
    @Autowired
    private UserService userService;

    @Autowired
    private AuthService authService;
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

    @PostMapping("/user")
    public void saveUser(@RequestBody RegisterDTO registerDTO){
        authService.register(registerDTO);
    }

    @PutMapping("/user")
    public void updateUser(@RequestBody User user){
        User dbUser = Optional.ofNullable(userService.getById(user.getId())).orElseThrow(() -> Errors.of("用户不存在"));
        userService.validUser(user);
        if (user.getPassword() != null){
            String password = MD5Util.encrypt(user.getPassword());
            if(!StringUtils.equals(dbUser.getPassword(),password)){
                user.setToken(null);
                user.setTokenExpireTime(new Date());
                user.setPassword(password);
            }
        }else {
            user.setToken(dbUser.getToken());
            user.setTokenExpireTime(dbUser.getTokenExpireTime());
            user.setPassword(dbUser.getPassword());
        }

        user.setUpdateTime(new Date());
        userService.saveOrUpdate(user);
    }

    @GetMapping("/user/{userId}")
    public User getUser(@PathVariable Integer userId){
        User user = userService.getById(userId);
        user.setPassword(null);
        return user;
    }

    @GetMapping("/user")
    public IPage<User> getUserPage(long page,long pageSize){
        return userService.page(new Page<>(page,pageSize));
    }

    @DeleteMapping("/user/{userId}")
    public void deleteUser(@PathVariable Integer userId){
        User dbUser = Optional.ofNullable(userService.getById(userId)).orElseThrow(() -> Errors.of("用户不存在"));
        userService.removeById(userId);
    }


}
