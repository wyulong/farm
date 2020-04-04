package com.farm.dto.res;

import lombok.*;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * @Author xhua
 * @Date 2020/4/4 18:25
 **/
@Data
@ToString
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ArticleDTO implements Serializable {

    private Integer id;

    /**
     * 作者ID
     */
    private String authorName;

    /**
     *  缩略图
     */
    private String coverImg;

    /**
     * 文章类别
     */
    private Integer type;

    /**
     *  类别描述
     */
    private String typeDesc;

    /**
     * 文章标题
     */
    private String title;

    /**
     * 文章内容
     */
    private String content;

    /**
     * 创建时间
     */
    private LocalDateTime createTime;

}
