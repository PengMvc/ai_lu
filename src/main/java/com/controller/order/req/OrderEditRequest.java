package com.controller.order.req;

import io.swagger.annotations.ApiModelProperty;

/**
 * @Author: PengMvc
 * @Date: 2022/06/01/20:04
 */
public class OrderEditRequest {

    @ApiModelProperty(value = "购买数量")
    private  Integer buyNum;

    @ApiModelProperty(value = "收货地址")
    private  String shippingAddress;

    @ApiModelProperty(value = "订单状态")
    private  Integer orderStatus;

    @ApiModelProperty(value = "userId",required = true)
    private  Integer userId;

    @ApiModelProperty(value = "订单号",required = true)
    private String orderNo;

    public Integer getBuyNum() {
        return buyNum;
    }

    public void setBuyNum(Integer buyNum) {
        this.buyNum = buyNum;
    }

    public String getShippingAddress() {
        return shippingAddress;
    }

    public void setShippingAddress(String shippingAddress) {
        this.shippingAddress = shippingAddress;
    }

    public Integer getOrderStatus() {
        return orderStatus;
    }

    public void setOrderStatus(Integer orderStatus) {
        this.orderStatus = orderStatus;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getOrderNo() {
        return orderNo;
    }

    public void setOrderNo(String orderNo) {
        this.orderNo = orderNo;
    }
}
