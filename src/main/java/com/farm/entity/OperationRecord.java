package com.farm.entity;

import lombok.*;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * <p>
 * 操作记录表
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
public class OperationRecord implements Serializable {

    private static final long serialVersionUID = 1L;

    private Integer id;

    /**
     * 操作人
     */
    private Integer userId;

    /**
     * 操作描述
     */
    private String describe;

    /**
     * 操作类型 1、施肥 2、打药
     */
    private Integer type;

    /**
     * 用量
     */
    private String usedAomut;

    /**
     * 操作时间
     */
    private LocalDateTime operationTime;

    /**
     * 创建时间
     */
    private LocalDateTime createTime;

    /**
     * 更新时间
     */
    private LocalDateTime updateTime;


}
