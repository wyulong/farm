package com.farm.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.farm.constants.Errors;
import com.farm.entity.ApplyRecord;
import com.farm.entity.Comment;
import com.farm.entity.User;
import com.farm.entity.UserCollect;
import com.farm.service.*;
import com.farm.util.Exceptions;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.Optional;

import static com.farm.constants.Errors.*;

/**
 * 普通用户接口
 *
 * @Author xhua
 * @Date 2020/3/22 0:28
 **/
@RestController
@RequestMapping("/user")
@Slf4j
public class UserController {

    @Resource
    private UserService userService;

    @Autowired
    private CommentService commentService;

    @Autowired
    private ApplyRecordService applyRecordService;

    @Autowired
    private UserCollectService collectService;

    @Autowired
    private ArticleService articleService;

    @GetMapping("/get-user")
    public User getUser(@RequestParam("id") Integer id) {
        return userService.getById(id);
    }

    /**
     * 补贴申请详情
     *
     * @param id
     * @return
     */
    @GetMapping("/apply/{id}")
    public ApplyRecord getRecord(@PathVariable Integer id) {
        return Optional.ofNullable(applyRecordService.getById(id)).orElseThrow(() -> Errors.of(NOT_FOUND));
    }

    /**
     * 补贴申请列表
     *
     * @param page 当前页
     * @param pageSize 每页数量
     * @return
     */
    @GetMapping("/apply")
    public IPage<ApplyRecord> getApplyRecordPage(@RequestParam Integer page, @RequestParam Integer pageSize) {
        return applyRecordService.getApplyRecordPage(page, pageSize);
    }

    /**
     * 增加补贴申请
     *
     * @param applyRecord
     */
    @PostMapping("/apply")
    public void save(@RequestBody ApplyRecord applyRecord) {
        applyRecord.setCreateTime(new Date());
        applyRecord.setUpdateTime(new Date());
        applyRecordService.save(applyRecord);
    }

    /**
     * 修改补贴申请
     *
     * @param applyRecord
     */
    @PutMapping("/apply")
    public void update(@RequestBody ApplyRecord applyRecord) {
        applyRecord.setUpdateTime(new Date());
        applyRecordService.updateById(applyRecord);
    }

    /**
     * 删除补贴申请
     *
     * @param id 补贴申请id
     */
    @DeleteMapping("/apply/{id}")
    public void delete(@PathVariable Integer id) {
        applyRecordService.removeById(id);
    }

    /**
     * 添加收藏
     *
     * @param articleId 文章id
     */
    @PostMapping("/collect/{articleId}")
    public void addCollect(@PathVariable Integer articleId) {
        Optional.ofNullable(articleService.getById(articleId)).orElseThrow(() -> of(NOT_FOUND));
        User currentUser = Optional.ofNullable(userService.currentUser()).orElseThrow(() -> of(INVALID_TOKEN));
        if (!collectService.exists(currentUser.getId(), articleId)) {
            UserCollect userCollect = UserCollect.builder()
                    .articleId(articleId)
                    .userId(currentUser.getId())
                    .createTime(LocalDateTime.now())
                    .updateTime(LocalDateTime.now())
                    .build();
            collectService.save(userCollect);
        }
    }

    /**
     * 取消收藏
     *
     * @param collectId 收藏id
     */
    @DeleteMapping("/collect/{collectId}")
    public void deleteCollect(@PathVariable Integer collectId) {
        collectService.removeById(collectId);
    }

    /**
     * 添加评论信息 & 修改评论信息
     *
     * @param comment
     */
    @PostMapping("/comment")
    public void addComment(@RequestBody Comment comment) {
        if (StringUtils.isBlank(comment.getContent())) {
            Exceptions.throwss("评论内容不能为空");
        }
        Comment comment1 = Comment.builder()
                .userId(userService.currentUser().getId())
                .content(comment.getContent())
                .createTime(LocalDateTime.now())
                .updateTime(LocalDateTime.now())
                .build();
        commentService.saveOrUpdate(comment1);
    }


}
