package com.farm.dto.req;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@AllArgsConstructor
@Builder
public class ApplyDTO {
    private Integer id;
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
    /**
     * 亩数
     */
    private String amount;
    /**
     * 申请理由
     */
    private String applyReason;
}
