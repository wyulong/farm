package com.farm.controller;

import com.farm.entity.Article;
import com.farm.service.ArticleService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * 技术人员模块
 * @Author xhua
 * @Date 2020/3/23 17:54
 **/
@RestController
@RequestMapping("/tech")
@Slf4j
public class TechnologyController {

    @Autowired
    private ArticleService articleService;

    /**
     * 新增文章&编辑文章
     * @param article
     */
    @PostMapping("/article/save")
    public void saveArticle(@RequestBody Article article){
        articleService.saveOrUpdate(article);
    }

    /**
     * 删除文章
     * @param id 文章id
     */
    @PostMapping("/article/delete")
    public void deleteArticle(@RequestParam Integer id){
        articleService.removeById(id);
    }



}
