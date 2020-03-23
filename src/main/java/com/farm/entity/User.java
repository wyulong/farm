package com.farm.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.*;

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

}
