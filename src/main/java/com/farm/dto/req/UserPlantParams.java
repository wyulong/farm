package com.farm.dto.req;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * @Author xhua
 * @Date 2020/4/8 14:51
 **/
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UserPlantParams implements Serializable {

    private Integer id;

    /**
     * 种植时间
     */
    private String plantTime;

    /**
     * 种植方式
     */
    private String plantType;

    /**
     * 产量
     */
    private String yield;
}
