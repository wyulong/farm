package com.farm.dto.req;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * @Author xhua
 * @Date 2020/4/6 21:23
 **/
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ArticleParamsDTO implements Serializable {

    private Integer id;

    /**
     * 文章类别
     */
    private Integer type;

    /**
     * 文章标题
     */
    private String title;

    /**
     *  封面图
     */
    private String coverImg;

    /**
     * 文章内容
     */
    private String content;

}
