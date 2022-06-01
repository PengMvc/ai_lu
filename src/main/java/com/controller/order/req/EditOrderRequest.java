package com.controller.order.req;

import io.swagger.annotations.ApiModelProperty;

/**
 * @Author: PengMvc
 * @Date: 2022/06/01/20:04
 */
public class EditOrderRequest {

    @ApiModelProperty(value = "购买数量")
    private  Integer buyNum;

    @ApiModelProperty(value = "收货地址")
    private  String shippingAddress;

    //private

}
