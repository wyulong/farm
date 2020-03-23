package com.farm.dto;

import com.farm.constants.ErrorResult;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Builder;
import lombok.Data;

import java.io.Serializable;

/**  统一结果集
 * @Author xhua
 * @Date 2020/3/22 0:46
 **/
@Data
@Builder
public class Result<T> implements Serializable {

    private int code;
    private String msg;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    private T data;

    public static <T> Result<T> success(T data){
        return Result.<T>builder().code(0).msg("ok").data(data).build();
    }

    public static <T> Result<T> success() {
        return Result.<T>builder().code(0).msg("OK").data(null).build();
    }

    public static <T> Result<T> error(ErrorResult errorResult) {
        return Result.<T>builder().code(errorResult.getCode()).msg(errorResult.getMessage()).data(null).build();
    }

    public static <T> Result<T> error(int code, String message) {
        return Result.<T>builder().code(code).msg(message).data(null).build();
    }

    public static <T> Result<T> error(String message) {
        return Result.<T>builder().code(-1).msg(message).data(null).build();
    }

    public static <T> Result<T> build(int code, String message,T data) {
        return Result.<T>builder().code(code).msg(message).data(data).build();
    }

}
