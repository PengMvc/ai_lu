package com.entity.order.orderevaluate;

import io.swagger.models.auth.In;

/**
 * @Author: PengMvc
 * @Date: 2022/06/27/17:55
 */
public class OrderEvaluate {

    /**evaluateId**/
    private Integer evaluateId;

    /**order no**/
    private String orderNo;

    /**goods star**/
    private Integer goodsStar;

    /** user id**/
    private Integer userId;

    /**img url**/
    private String imgUrl;

    /**user evaluate**/
    private String userEvaluate;

    /**goods star**/
    private int goodsWrapStar;

    /**logistics speed star**/
    private int logisticsSpeedStar;

    /**delivery Man Star**/
    private int deliveryManStar;

    public Integer getEvaluateId() {
        return evaluateId;
    }

    public void setEvaluateId(Integer evaluateId) {
        this.evaluateId = evaluateId;
    }

    public String getOrderNo() {
        return orderNo;
    }

    public void setOrderNo(String orderNo) {
        this.orderNo = orderNo;
    }

    public Integer getGoodsStar() {
        return goodsStar;
    }

    public void setGoodsStar(Integer goodsStar) {
        this.goodsStar = goodsStar;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
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
