package com.farm.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.farm.annotation.OpenApi;
import com.farm.configurations.UploadConfiguration;
import com.farm.dto.req.LoginParamsDTO;
import com.farm.dto.req.RegisterDTO;
import com.farm.dto.res.ArticleDTO;
import com.farm.dto.res.BusinessSumupDTO;
import com.farm.dto.res.LoginInfoDTO;
import com.farm.service.ArticleService;
import com.farm.service.AuthService;
import com.farm.service.BusinessSumupService;
import com.farm.util.Exceptions;
import com.farm.util.FileUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import java.util.Collections;
import java.util.List;

/**  通用接口
 * @Author xhua
 * @Date 2020/3/23 14:39
 **/
//登录、评论、收藏、搜索功能  不做权限拦截
@RestController
@RequestMapping("/common")
@Slf4j
public class CommonController {

    @Resource
    private AuthService authService;

    @Resource
    private ArticleService articleService;

    @Resource
    private UploadConfiguration uploadConfiguration;

    @Resource
    private BusinessSumupService businessSumupService;

    /**
     *  注册接口
     * @param registerDTO
     * @return
     */
    @PostMapping("/register")
    public Boolean register(@RequestBody RegisterDTO registerDTO){
        return authService.register(registerDTO);
    }

    /**
     *  登录接口
     * @param loginParamsDTO
     * @return
     */
    @PostMapping("/login")
    @OpenApi
    public LoginInfoDTO login(@RequestBody LoginParamsDTO loginParamsDTO){
        return authService.verifyPhoneAndPassword(loginParamsDTO.getPhone(), loginParamsDTO.getPassword());
    }

    /**
     *   菜单权限接口
     */
    @GetMapping("/menu")
    public List menu(){
        //TODO 根据角色返回角色权限
        return Collections.emptyList();
    }

    /**
     *  搜索文章
     * @param content
     * @return
     */
    @GetMapping("/article/search")
    public IPage<ArticleDTO> search(@RequestParam(value = "content",required = false)String content,@RequestParam("page") Long page, @RequestParam("pageSize") Long pageSize){
        return articleService.searchArticle(content,page,pageSize);
    }

    /**
     *  公告
     * @param page
     * @param pageSize
     * @return
     */
    @GetMapping("/notice")
    public IPage<ArticleDTO> notice(@RequestParam("page")Long page, @RequestParam("pageSize")Long pageSize){
        return articleService.getNotice(page,pageSize);
    }

    /**
     *  下乡总结
     * @param page
     * @param pageSize
     * @return
     */
    @GetMapping("/sumup")
    public IPage<BusinessSumupDTO> listSumup(@RequestParam("page")Long page, @RequestParam("pageSize")Long pageSize){
        return businessSumupService.listSumup(page,pageSize);
    }

    @GetMapping("/sumup-detail")
    public BusinessSumupDTO sumupDetail(@RequestParam("id")Integer id){
        return businessSumupService.sumupDetail(id);
    }

    /**
     *  上传文件
     * @param file
     * @return
     */
    @ResponseBody
    @RequestMapping("upload")
    public String upload(@RequestParam("file")MultipartFile file){

        String fileName = file.getOriginalFilename();
        fileName = FileUtil.renameFile(fileName);

        try {
            FileUtil.upload(file.getBytes(),uploadConfiguration.getFilePath(),fileName);
        }catch (Exception e){
            Exceptions.throwss("上传文件失败");
        }

        return "/static/" + fileName;
    }

}
