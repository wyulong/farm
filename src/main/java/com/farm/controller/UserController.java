package com.farm.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.farm.constants.ApplyStatus;
import com.farm.constants.DateStatus;
import com.farm.constants.Errors;
import com.farm.dto.req.ApplyParamsDTO;
import com.farm.dto.req.CommentDTO;
import com.farm.dto.req.CommentParam;
import com.farm.dto.res.ApplyDTO;
import com.farm.entity.*;
import com.farm.service.*;
import com.farm.util.Exceptions;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

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

    @Autowired
    private UserPlantService userPlantService;

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
    public IPage<ApplyDTO> getApplyRecordPage(@RequestParam Integer page, @RequestParam Integer pageSize) {
        User user = userService.currentUser();
        return applyRecordService.getApplyRecordPage(user.getId(), page, pageSize);
    }

    /**
     * 增加补贴申请
     *
     * @param dto
     */
    @PostMapping("/apply")
    public Boolean save(@RequestBody ApplyParamsDTO dto) {

        ApplyRecord applyRecord = new ApplyRecord();
        BeanUtils.copyProperties(dto,applyRecord);
        applyRecord.setUserId(userService.currentUser().getId());
        applyRecord.setCreateTime(new Date());
        applyRecord.setUpdateTime(new Date());
        applyRecord.setStatus(ApplyStatus.APPLY.getCode());
        return applyRecordService.save(applyRecord);
    }

    /**
     * 修改补贴申请
     *
     * @param dto
     */
    @PutMapping("/apply")
    public Boolean update(@RequestBody ApplyParamsDTO dto) {
        ApplyRecord applyRecord = new ApplyRecord();
        BeanUtils.copyProperties(dto,applyRecord);
        applyRecord.setUserId(userService.currentUser().getId());
        applyRecord.setUpdateTime(new Date());
        applyRecord.setStatus(ApplyStatus.APPLY.getCode());
        return applyRecordService.updateById(applyRecord);
    }

    /**
     * 删除补贴申请
     *
     * @param id 补贴申请id
     */
    @DeleteMapping("/apply/{id}")
    public Boolean delete(@PathVariable Integer id) {
        //只能删除用户所属的数据
        User user = userService.currentUser();
        QueryWrapper queryWrapper = new QueryWrapper();
        queryWrapper.eq("user_id",user.getId());
        queryWrapper.eq("id",id);
        ApplyRecord applyRecord = applyRecordService.getOne(queryWrapper);
        if (applyRecord == null){
            Exceptions.throwss("补贴申请不存在");
        }
        //没有软删除，直接物理删除
        return applyRecordService.removeById(id);
    }

    /**
     * 收藏列表
     *
     * @param page 当前页
     * @param pageSize 每页数量
     * @return
     */
    @GetMapping("/collect")
    public IPage<UserCollect> getCollectPage(@RequestParam Integer page, @RequestParam Integer pageSize) {
        User user = userService.currentUser();
        return collectService.getCollectPage(user.getId(), page, pageSize);
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
                    .status(DateStatus.VALID.getCode())
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
        UserCollect collect = collectService.getById(collectId);
        if (collect == null){
            Exceptions.throwss("收藏不存在");
        }else {
            collect.setStatus(DateStatus.INVALID.getCode());
            collectService.saveOrUpdate(collect);
        }
    }

    /**
     * 获取文章评论信息
     *
     * @param articleId
     */
    @GetMapping("/comment/{articleId}")
    public List<CommentDTO> getComment(@PathVariable Integer articleId) {
        Integer currentUserId = userService.currentUser().getId();
        List<Comment> comments = commentService.getByArticleId(articleId);
        Map<Integer,String> userNameMap = userService.getNameMap();
        List<CommentDTO> commentDTOList = comments.stream().map(comment ->
                CommentDTO.builder().id(comment.getId())
                        .content(comment.getContent())
                        .createTime(comment.getCreateTime())
                        .updateTime(comment.getUpdateTime())
                        .userName(userNameMap.getOrDefault(comment.getUserId(), "未知用户"))
                        .canMod(currentUserId.equals(comment.getUserId()) ? 1 : 0)
                        .build()).collect(Collectors.toList());
        return commentDTOList;
    }


    /**
     * 添加评论信息 & 修改评论信息
     *
     * @param param
     */
    @PostMapping("/comment")
    public void addComment(@RequestBody CommentParam param) {
        if (StringUtils.isBlank(param.getContent())) {
            Exceptions.throwss("评论内容不能为空");
        }
        Comment comment1 = Comment.builder()
                .userId(userService.currentUser().getId())
                .content(param.getContent())
                .updateTime(LocalDateTime.now())
                .status(DateStatus.VALID.getCode())
                .articleId(param.getArticleId())
                .build();
        if (param.getId() == null){
            comment1.setCreateTime(LocalDateTime.now());
        }
        commentService.saveOrUpdate(comment1);
    }

    /**
     *  添加&修改种植信息
     * @param userPlant
     */
    @PostMapping("/plant")
    public void savePlantInfo(@RequestBody UserPlant userPlant){
        userPlant.setUserId(userService.currentUser().getId());
        userPlant.setUpdateTime(LocalDateTime.now());
        userPlantService.saveOrUpdate(userPlant);
    }

    /**
     *  删除种植信息
     * @param id
     */
    @DeleteMapping("/plant/{id}")
    public void deletePalntInfo(@PathVariable("id")Integer id){
        UserPlant plant = userPlantService.getById(id);
        if (plant == null){
            Exceptions.throwss("种植信息不存在");
        }
        userPlantService.removeById(id);
    }

    /**
     *  种植信息列表
     * @param page
     * @param pageSize
     * @return
     */
    @GetMapping("/list-plant")
    public IPage<UserPlant> getPlantInfo(long page, long pageSize){
        User user = userService.currentUser();
        return userPlantService.getPlantInfo(user.getId(),page,pageSize);
    }


}
