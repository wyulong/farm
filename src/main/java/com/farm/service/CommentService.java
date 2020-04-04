package com.farm.service;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.farm.entity.Comment;
import com.baomidou.mybatisplus.extension.service.IService;
import com.farm.mapper.CommentMapper;
import org.springframework.stereotype.Service;

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

}

