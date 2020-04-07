package com.farm.dto.req;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * @Author xhua
 * @Date 2020/4/7 15:22
 **/
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class BusinessSumupParamsDTO implements Serializable {

    private Integer id;

    /**
     * 下乡时间
     */
    private String time;

    /**
     *  封面缩略图
     */
    private String coverImg;

    /**
     * 内容
     */
    private String content;

}
