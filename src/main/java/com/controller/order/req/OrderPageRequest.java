package com.controller.order.req;

import com.common.PageRequest;
import io.swagger.annotations.ApiModelProperty;

/**
 * @Author: PengMvc
 * @Date: 2022/06/13/17:02
 */
public class OrderPageRequest extends PageRequest {

    @ApiModelProperty(value = "用户ID")
    private Integer userId;

    @ApiModelProperty(value = "订单状态")
    private Integer orderStatus;

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Integer getOrderStatus() {
        return orderStatus;
    }

    public void setOrderStatus(Integer orderStatus) {
        this.orderStatus = orderStatus;
    }
}
