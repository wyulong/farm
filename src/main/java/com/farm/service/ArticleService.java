package com.farm.service;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.farm.entity.Article;
import com.baomidou.mybatisplus.extension.service.IService;
import com.farm.mapper.ArticleMapper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * <p>
 * 文章表 服务类
 * </p>
 *
 * @author wyulong
 * @since 2020-03-27
 */
@Service
public class ArticleService extends ServiceImpl<ArticleMapper, Article> {

    @Resource
    private ArticleMapper articleMapper;


    public List<Article> searchArticle(String content) {
        return articleMapper.searchArticle(content);
    }
}
