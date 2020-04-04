package com.farm.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.*;

import java.util.Date;

/**
 * @Author xhua
 * @Date 2020/3/24 21:49
 **/
@TableName("apply_record")
@Data
@ToString
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ApplyRecord {

    @TableId(type = IdType.AUTO)
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
    private Integer authId;
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
