package com.farm.dto.res;

import lombok.*;

import java.io.Serializable;

/**
 * @Author xhua
 * @Date 2020/4/7 17:28
 **/
@Data
@ToString
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class RoleModuleDTO implements Serializable {

    private Integer moduleId;
    private String moduleName;
    private String url;

}
