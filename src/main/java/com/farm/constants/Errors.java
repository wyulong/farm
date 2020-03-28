package com.farm.constants;

import com.farm.dto.BizException;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Author xhua
 * @Date 2020/3/22 0:50
 **/
@AllArgsConstructor
@NoArgsConstructor
public enum Errors {

    SMS_VERIFY_ERROR(-1, "incorrect verification code"),
    ILLEGAL_PARAMS(400, "illegal arguments"),
    INVALID_TOKEN(401, "invalid token"),
    NOT_ACCEPT(406,"invalid request"),
    SERVER_ERROR(500,"server exception"),
    NOT_FOUND(404,"请求数据不存在"),
    ;

    private int code;
    private String message;

    public int getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }

    public static BizException of(Errors errors){
        return new BizException(errors);
    }

}
