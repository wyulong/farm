package com.farm.entity;

import lombok.*;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * <p>
 * 文章表
 * </p>
 *
 * @author wyulong
 * @since 2020-03-27
 */
@Data
@ToString
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Article implements Serializable {

    private static final long serialVersionUID = 1L;

    private Integer id;

    /**
     * 作者ID
     */
    private Integer authorId;

    /**
     * 文章类别
     */
    private Integer type;

    /**
     * 文章标题
     */
    private String title;

    /**
     * 文章内容
     */
    private String content;

    /**
     * 状态
     */
    private Integer status;

    /**
     * 创建时间
     */
    private LocalDateTime createTime;

    /**
     * 更新时间
     */
    private LocalDateTime updateTime;

}
