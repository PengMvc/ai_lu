package com.controller.order.req;

import io.swagger.annotations.ApiModelProperty;

/**
 * @Author: PengMvc
 * @Date: 2022/06/24/10:46
 */
public class OrderEvaluateRequest {

    @ApiModelProperty(value = "用户ID",required = true)
    private Integer userId;

    @ApiModelProperty(value = "订单号",required = true)
    private String orderNo;

    @ApiModelProperty("商品评价星级")
    private int goodsStar;

    @ApiModelProperty(value = "图片url",required = false)
    private String imgUrl;

    @ApiModelProperty(value = "用户评价",required = false)
    private String userEvaluate;

    @ApiModelProperty("商品包装星级")
    private int goodsWrapStar;

    @ApiModelProperty("物流速度星级")
    private int logisticsSpeedStar;

    @ApiModelProperty("配送员服务星级")
    private int deliveryManStar;

    @ApiModelProperty(value = "订单状态",required = true)
    private Integer orderStatus;

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

    public int getGoodsStar() {
        return goodsStar;
    }

    public void setGoodsStar(int goodsStar) {
        this.goodsStar = goodsStar;
    }

    public String getImgUrl() {
        return imgUrl;
    }

    public void setImgUrl(String imgUrl) {
        this.imgUrl = imgUrl;
    }

    public String getUserEvaluate() {
        return userEvaluate;
    }

    public void setUserEvaluate(String userEvaluate) {
        this.userEvaluate = userEvaluate;
    }

    public int getGoodsWrapStar() {
        return goodsWrapStar;
    }

    public void setGoodsWrapStar(int goodsWrapStar) {
        this.goodsWrapStar = goodsWrapStar;
    }

    public int getLogisticsSpeedStar() {
        return logisticsSpeedStar;
    }

    public void setLogisticsSpeedStar(int logisticsSpeedStar) {
        this.logisticsSpeedStar = logisticsSpeedStar;
    }

    public int getDeliveryManStar() {
        return deliveryManStar;
    }

    public void setDeliveryManStar(int deliveryManStar) {
        this.deliveryManStar = deliveryManStar;
    }
}
