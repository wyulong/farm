package com.farm.service.impl;

import com.farm.entity.Article;
import com.farm.mapper.ArticleMapper;
import com.farm.service.ArticleService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 文章表 服务实现类
 * </p>
 *
 * @author wyulong
 * @since 2020-03-27
 */
@Service
public class ArticleServiceImpl extends ServiceImpl<ArticleMapper, Article> implements ArticleService {

}
