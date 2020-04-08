package com.farm.dto.req;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.*;

import java.time.LocalDateTime;
@Data
@ToString
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class CommentDTO {

        private Integer id;

        /**
         * 评论人
         */
        private String userName;

        /**
         * 评论内容
         */
        private String content;

        /**
         * 评论时间
         */
        private LocalDateTime createTime;

        /**
         * 更新时间
         */
        private LocalDateTime updateTime;

        /**
         * 是否可以修改、删除
         */
        private Integer canMod;

    }