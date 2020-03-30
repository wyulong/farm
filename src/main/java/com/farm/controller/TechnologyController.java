package com.farm.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.farm.constants.DateStatus;
import com.farm.constants.Errors;
import com.farm.entity.Article;
import com.farm.entity.BusinessSumup;
import com.farm.service.ArticleService;
import com.farm.service.AuthService;
import com.farm.service.BusinessSumupService;
import com.farm.service.UserService;
import com.farm.util.Exceptions;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.Optional;

import static com.farm.constants.Errors.CONTENT_EMPTY;
import static com.farm.constants.Errors.NOT_FOUND;

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

    @Autowired
    private BusinessSumupService sumupService;

    /**
     * 新增文章&编辑文章
     * @param article
     */
    @PostMapping("/article")
    public void saveArticle(@RequestBody Article article){
        article.setAuthorId(userService.currentUser().getId());
        article.setStatus(DateStatus.VALID.getCode());
        articleService.saveOrUpdate(article);
    }

    /**
     * 删除文章
     * @param id 文章id
     */
    @DeleteMapping("/article")
    public void deleteArticle(@RequestParam Integer id){
        Article article = articleService.getById(id);
        if (article == null){
            Exceptions.throwss("文章不存在");
        }else {
            article.setStatus(DateStatus.INVALID.getCode());
            articleService.saveOrUpdate(article);
        }
    }

    @PostMapping("/sumup")
    public void saveBusinessSumup(@RequestBody BusinessSumup businessSumup){
        if (StringUtils.isBlank(businessSumup.getContent())){
            Exceptions.throwss(CONTENT_EMPTY);
        }
        businessSumup.setAuthorId(userService.currentUser().getId());
        if (businessSumup.getId() == null){
            businessSumup.setCreateTime(LocalDateTime.now());
        }
        businessSumup.setUpdateTime(LocalDateTime.now());
        businessSumup.setStatus(DateStatus.VALID.getCode());
        sumupService.saveOrUpdate(businessSumup);
    }

    @GetMapping("/sumup")
    public IPage<BusinessSumup> getBusinessSumup(long page, long pageSize) {
        return sumupService.page(new Page<>(page, pageSize));
    }

    @GetMapping("/sumup/{sumupId}")
    public BusinessSumup getBusinessSumup(@PathVariable Integer sumupId){
        return sumupService.getById(sumupId);
    }


    @DeleteMapping("/sumup/{sumupId}")
    public void deleteSumup(@PathVariable Integer sumupId){
        BusinessSumup businessSumup = Optional.ofNullable(sumupService.getById(sumupId)).orElseThrow(() -> Errors.of(NOT_FOUND));
        businessSumup.setStatus(DateStatus.INVALID.getCode());
        sumupService.saveOrUpdate(businessSumup);
    }


}
