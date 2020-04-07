package com.farm.dto.res;

import lombok.*;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * @Author xhua
 * @Date 2020/4/7 15:53
 **/
@Data
@ToString
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class BusinessSumupDTO implements Serializable {

    private Integer id;
    private Integer authorId;
    private String authorName;
    private String title;
    private LocalDateTime time;
    private String coverImg;
    private String content;
    private String createTime;

}
