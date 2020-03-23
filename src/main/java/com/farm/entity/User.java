package com.farm.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.*;

import java.util.Date;

/**
 * @Author xhua
 * @Date 2020/3/22 0:25
 **/
@TableName("user")
@Data
@ToString
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class User {

    private Integer id;
    private String name;
    private String phone;
    private String password;
    private Date tokenExpireTime;
    private Date createTime;
    private Date updateTime;

}
