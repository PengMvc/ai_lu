package com.controller.order.res;

import com.alibaba.excel.annotation.ExcelIgnore;
import com.alibaba.excel.annotation.ExcelProperty;
import com.common.ailuenum.OrderEnum;
import io.swagger.annotations.ApiModelProperty;

import java.math.BigDecimal;

/**
 * @Author: PengMvc
 * @Date: 2022/06/20/16:29
 */
public class OrdersExcelResponse {

    @ApiModelProperty(value = "序号")
    @ExcelProperty(value = "序号",index = 0)
    private Integer index;

    @ApiModelProperty("订单号")
    @ExcelProperty(value = "订单号",index = 1)
    private String orderNo;

    @ApiModelProperty("商品名称")
    @ExcelProperty(value = "商品名称",index = 2)
    private String goodsName;

    @ApiModelProperty("购买数量")
    @ExcelProperty(value = "购买数量",index = 3)
    private Integer buyNum;

    @ApiModelProperty("商品总价")
    @ExcelProperty(value = "商品总价",index = 4)
    private BigDecimal goodsTotalPrice;

    @ApiModelProperty("物流费用")
    @ExcelProperty(value = "物流费用",index = 5)
    private BigDecimal logisticsFee;

    @ApiModelProperty("订单总价")
    @ExcelProperty(value = "订单总价",index = 6)
    private BigDecimal orderTotalPrice;

    @ApiModelProperty("收货地址")
    @ExcelProperty(value = "收货地址",index = 7)
    private String shippingAddress;

    @ExcelIgnore
    private Integer orderStatus;

    @ApiModelProperty("订单状态")
    @ExcelProperty(value = "订单状态",index = 8)
    private String orderStatus1;

    @ApiModelProperty("购买人")
    @ExcelProperty(value = "购买人",index = 9)
    private String userName;

    public Integer getIndex() {
        return index;
    }

    public void setIndex(Integer index) {
        this.index = index;
    }

    public String getOrderNo() {
        return orderNo;
    }

    public void setOrderNo(String orderNo) {
        this.orderNo = orderNo;
    }

    public String getGoodsName() {
        return goodsName;
    }

    public void setGoodsName(String goodsName) {
        this.goodsName = goodsName;
    }

    public Integer getBuyNum() {
        return buyNum;
    }

    public void setBuyNum(Integer buyNum) {
        this.buyNum = buyNum;
    }

    public BigDecimal getGoodsTotalPrice() {
        return goodsTotalPrice;
    }

    public void setGoodsTotalPrice(BigDecimal goodsTotalPrice) {
        this.goodsTotalPrice = goodsTotalPrice;
    }

    public BigDecimal getLogisticsFee() {
        return logisticsFee;
    }

    public void setLogisticsFee(BigDecimal logisticsFee) {
        this.logisticsFee = logisticsFee;
    }

    public BigDecimal getOrderTotalPrice() {
        return orderTotalPrice;
    }

    public void setOrderTotalPrice(BigDecimal orderTotalPrice) {
        this.orderTotalPrice = orderTotalPrice;
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

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getOrderStatus1() {
        return OrderEnum.getStatusMsg(orderStatus);
    }

    public void setOrderStatus1(String orderStatus1) {
        this.orderStatus1 = orderStatus1;
    }
}
