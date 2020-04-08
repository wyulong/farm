package com.farm.dto.res;

import lombok.*;

import java.io.Serializable;
import java.util.Date;

/**
 * @Author xhua
 * @Date 2020/4/8 10:36
 **/
@Data
@ToString
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ApplyDTO implements Serializable {

    private Integer id;
    /**
     * 用户编号
     */
    private Integer userId;
    /**
     * 用户名称
     */
    private String userName;
    /**
     * 手机号码
     */
    private String phone;
    /**
     * 地址
     */
    private String address;
    private String amount;
    /**
     * 申请理由
     */
    private String applyReason;
    private String content;
    private Integer status;
    private String statusDesc;
    private String authName;
    private String refuseDesc;
    /**
     * 创建时间
     */
    private Date createTime;
    /**
     * 更新时间
     */
    private Date updateTime;

}
