package com.farm.service;

import com.farm.entity.Article;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * <p>
 * 文章表 服务类
 * </p>
 *
 * @author wyulong
 * @since 2020-03-27
 */
public interface ArticleService extends IService<Article> {

    List<Article> searchArticle(String content);

}
