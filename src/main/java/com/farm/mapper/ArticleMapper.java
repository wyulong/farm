package com.farm.mapper;

import com.farm.dto.res.ArticleDTO;
import com.farm.entity.Article;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * <p>
 * 文章表 Mapper 接口
 * </p>
 *
 * @author wyulong
 * @since 2020-03-27
 */
public interface ArticleMapper extends BaseMapper<Article> {

    List<ArticleDTO> searchArticle(@Param("content")String content);

}
