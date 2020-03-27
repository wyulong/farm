package com.farm.service.impl;

import com.farm.entity.Comment;
import com.farm.mapper.CommentMapper;
import com.farm.service.CommentService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 评论表 服务实现类
 * </p>
 *
 * @author wyulong
 * @since 2020-03-27
 */
@Service
public class CommentServiceImpl extends ServiceImpl<CommentMapper, Comment> implements CommentService {

}
