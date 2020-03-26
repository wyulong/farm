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
    private Integer userId;
    private String userName;
    private String phone;
    private String address;
    private String amount;
    private String applyReason;
    private String content;
    private Integer status;
    private Integer authId;
    private String refuseDesc;
    private Date createTime;
    private Date updateTime;

}
