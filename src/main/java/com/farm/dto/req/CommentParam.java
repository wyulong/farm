package com.farm.dto.req;

import lombok.*;

import java.time.LocalDateTime;

@Data
@ToString
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class CommentParam {

        private Integer id;

        /**
         * 评论内容
         */
        private String content;

        /**
         * 文章id
         */
        private Integer articleId;

    }