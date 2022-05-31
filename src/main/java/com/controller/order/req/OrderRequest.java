package com.controller.order.req;

import io.swagger.models.auth.In;

import java.math.BigDecimal;
import java.util.Date;

/**
 * @Author: PengMvc
 * @Date: 2022/05/30/21:14
 */
public class OrderRequest {

    /**order No*/
    private String orderNO;

    /**order num*/
    private Integer buyNum;

    /**goods no*/
    private Integer goodsNo;

    /**the price of order*/
    private BigDecimal orderTotalPrice;

    /** logistics fee*/
    private BigDecimal logisticsFee;

    /**shipping address*/
    private String shippingAddress;

    /**the no of shipping*/
    private Integer orderLogisticsId;

    /**pay channel*/
    private Integer payChannel;

    /**userId*/
    private Integer userId;

    /**user comment*/
    private String userComment;

    /**create date*/
    private Date createDate;

    /**goods total price*/
    private BigDecimal goodsTotalPrice;

    /**the status of order*/
    private Integer orderStatus;

    /**ship id*/
    private Integer shopId;

    public BigDecimal getGoodsTotalPrice() {
        return goodsTotalPrice;
    }

    public Integer getShopId() {
        return shopId;
    }

    public void setShopId(Integer shopId) {
        this.shopId = shopId;
    }

    public Integer getOrderStatus() {
        return orderStatus;
    }

    public void setOrderStatus(Integer orderStatus) {
        this.orderStatus = orderStatus;
    }

    public void setGoodsTotalPrice(BigDecimal goodsTotalPrice) {
        this.goodsTotalPrice = goodsTotalPrice;
    }

    public Integer getBuyNum() {
        return buyNum;
    }

    public void setBuyNum(Integer buyNum) {
        this.buyNum = buyNum;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public String getOrderNO() {
        return orderNO;
    }

    public void setOrderNO(String orderNO) {
        this.orderNO = orderNO;
    }

    public BigDecimal getOrderTotalPrice() {
        return orderTotalPrice;
    }

    public void setOrderTotalPrice(BigDecimal orderTotalPrice) {
        this.orderTotalPrice = orderTotalPrice;
    }

    public BigDecimal getLogisticsFee() {
        return logisticsFee;
    }

    public void setLogisticsFee(BigDecimal logisticsFee) {
        this.logisticsFee = logisticsFee;
    }

    public String getShippingAddress() {
        return shippingAddress;
    }

    public void setShippingAddress(String shippingAddress) {
        this.shippingAddress = shippingAddress;
    }

    public Integer getOrderLogisticsId() {
        return orderLogisticsId;
    }

    public void setOrderLogisticsId(Integer orderLogisticsId) {
        this.orderLogisticsId = orderLogisticsId;
    }

    public Integer getPayChannel() {
        return payChannel;
    }

    public void setPayChannel(Integer payChannel) {
        this.payChannel = payChannel;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getUserComment() {
        return userComment;
    }

    public void setUserComment(String userComment) {
        this.userComment = userComment;
    }

    public Integer getGoodsNo() {
        return goodsNo;
    }

    public void setGoodsNo(Integer goodsNo) {
        this.goodsNo = goodsNo;
    }
}
