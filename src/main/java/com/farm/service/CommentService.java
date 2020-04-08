package com.farm.service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.farm.entity.Comment;
import com.baomidou.mybatisplus.extension.service.IService;
import com.farm.mapper.CommentMapper;
import org.hibernate.validator.constraints.pl.REGON;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * <p>
 * 评论表 服务类
 * </p>
 *
 * @author wyulong
 * @since 2020-03-27
 */
@Service
public class CommentService extends ServiceImpl<CommentMapper, Comment>{

    @Resource
    private CommentMapper commentMapper;

    public List<Comment> getByArticleId(Integer articleId) {
        QueryWrapper<Comment> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("article_id",articleId).eq("status",1).orderByDesc("create_time");
        return commentMapper.selectList(queryWrapper);

    }
}

