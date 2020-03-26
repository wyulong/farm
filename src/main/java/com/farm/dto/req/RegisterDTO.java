package com.farm.dto.req;

import lombok.Data;
import lombok.ToString;

/**
 * @Author xhua
 * @Date 2020/3/26 21:55
 **/
@Data
@ToString
public class RegisterDTO {

    private String name;
    private String phone;
    private String password;
    private String cardId;

}
