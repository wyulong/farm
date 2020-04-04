package com.farm.service;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.farm.constants.ArticleType;
import com.farm.constants.Enums;
import com.farm.dto.res.ArticleDTO;
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


    public List<ArticleDTO> searchArticle(String content) {
        List<ArticleDTO> list = articleMapper.searchArticle(content);
        //文章描述
        for (ArticleDTO articleDTO:list){
            ArticleType articleType = Enums.valueOf(articleDTO.getType(),ArticleType.class);
            articleDTO.setTypeDesc(articleType == null ? null:articleType.getDesc());
        };

        return list;
    }
}
