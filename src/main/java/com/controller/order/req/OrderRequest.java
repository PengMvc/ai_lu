package com.controller.order.req;

import io.swagger.annotations.ApiModelProperty;
import java.math.BigDecimal;
import java.util.Date;

/**
 * @Author: PengMvc
 * @Date: 2022/05/30/21:14
 */
public class OrderRequest {

    @ApiModelProperty(hidden = true,value = "订单号")
    private String orderNo;

    @ApiModelProperty(value = "购买数量" ,required=true)
    private Integer buyNum;

    @ApiModelProperty(value = "商品编号" ,required=true)
    private Integer goodsNo;

    @ApiModelProperty(hidden = true,value="订单总价")
    private BigDecimal orderTotalPrice;

    @ApiModelProperty(value = "物流费用" ,required=true)
    private BigDecimal logisticsFee;

    @ApiModelProperty(value = "收货地址" ,required=true)
    private String shippingAddress;

    @ApiModelProperty(value = "物流方式" ,required=true)
    private Integer orderLogisticsId;

    @ApiModelProperty(value = "支付方式" ,required=true)
    private Integer payChannel;

    @ApiModelProperty(value = "客户id" ,required=true)
    private Integer userId;

    @ApiModelProperty(value = "客户备注" ,required=true)
    private String userComment;

    @ApiModelProperty(hidden = true,value = "订单创建时间")
    private Date createDate;

    @ApiModelProperty(hidden = true,value="商品总价")
    private BigDecimal goodsTotalPrice;

    @ApiModelProperty(hidden = true,value = "订单状态")
    private Integer orderStatus;

    @ApiModelProperty(value = "商店id" ,required=true)
    private Integer shopId;

    @ApiModelProperty(value = "商品名称" ,hidden = true)
    private String goodsName;

    public BigDecimal getGoodsTotalPrice() {
        return goodsTotalPrice;
    }

    public Integer getShopId() {
        return shopId;
    }

    public String getGoodsName() {
        return goodsName;
    }

    public void setGoodsName(String goodsName) {
        this.goodsName = goodsName;
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

    public String getOrderNo() {
        return orderNo;
    }

    public void setOrderNo(String orderNo) {
        this.orderNo = orderNo;
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
