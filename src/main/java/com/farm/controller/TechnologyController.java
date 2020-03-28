package com.farm.controller;

import com.farm.constants.ArticleStatus;
import com.farm.entity.Article;
import com.farm.entity.User;
import com.farm.interceptor.SessionContext;
import com.farm.service.ArticleService;
import com.farm.service.AuthService;
import com.farm.service.UserService;
import com.farm.util.Exceptions;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Date;

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
    private AuthService authService;

    @Autowired
    private ArticleService articleService;

    @Autowired
    private UserService userService;

    /**
     * 新增文章&编辑文章
     * @param article
     */
    @PostMapping("/article/save")
    public void saveArticle(@RequestBody Article article){
        article.setAuthorId(userService.currentUser().getId());
        article.setStatus(ArticleStatus.VALID.getCode());
        articleService.saveOrUpdate(article);
    }

    /**
     * 删除文章
     * @param id 文章id
     */
    @PostMapping("/article/delete")
    public void deleteArticle(@RequestParam Integer id){
        Article article = articleService.getById(id);
        if (article == null){
            Exceptions.throwss("文章不存在");
        }else {
            article.setStatus(ArticleStatus.INVALID.getCode());
            articleService.saveOrUpdate(article);
        }
    }



}
