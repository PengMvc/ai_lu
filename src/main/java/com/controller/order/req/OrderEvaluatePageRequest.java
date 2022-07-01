package com.controller.order.req;

import com.common.PageRequest;
import io.swagger.annotations.ApiModelProperty;
import io.swagger.models.auth.In;

/**
 * @Author: PengMvc
 * @Date: 2022/07/01/13:56
 */
public class OrderEvaluatePageRequest extends PageRequest {

    @ApiModelProperty(value = "用户id")
    private Integer userId;

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }
}
