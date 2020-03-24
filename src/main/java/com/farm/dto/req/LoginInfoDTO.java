package com.farm.dto.req;

import lombok.Data;
import lombok.ToString;

/**  登录信息
 * @Author xhua
 * @Date 2020/3/24 16:19
 **/
@Data
@ToString
public class LoginInfoDTO {

    private String phone;
    private String password;

}
