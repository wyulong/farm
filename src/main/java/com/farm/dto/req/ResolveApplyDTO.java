package com.farm.dto.req;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.List;

/**  补贴审核
 * @Author xhua
 * @Date 2020/4/8 21:09
 **/
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ResolveApplyDTO implements Serializable {

    private Integer applyId;
    private Integer status;
    private List<String> images;
    private String refuseDesc;

}
