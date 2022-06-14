package com.controller.goods.req;

import io.swagger.annotations.ApiModelProperty;

import java.math.BigDecimal;

/**
 * @Author: PengMvc
 * @Date: 2022/06/14/21:22
 */
public class AddGoodsRequest {

    @ApiModelProperty(value = "商品图片")
    private String goodsImg;

    @ApiModelProperty(value = "商品名称")
    private String goodsName;

    @ApiModelProperty(value = "商品价格")
    private BigDecimal goodsPrice;

    @ApiModelProperty(value = "商品描述")
    private String goodsDesc;

    @ApiModelProperty(value = "商品库存")
    private Integer goodsNum;

    @ApiModelProperty(value = "商品发货地")
    private String goodsSendLocation;

    @ApiModelProperty(value = "商品来源")
    private String goodsSource;

    @ApiModelProperty(value = "商品是否在售")
    private Integer isOnSale;

    @ApiModelProperty(value = "商品一级分类")
    private String firstCategory;

    @ApiModelProperty(value = "商品二级分类")
    private String secondCategory;

    @ApiModelProperty(value = "商品三级分类")
    private String thirdCategory;

    @ApiModelProperty(value = "商品编号",hidden = true)
    private String goodsNo;

    public String getGoodsImg() {
        return goodsImg;
    }

    public void setGoodsImg(String goodsImg) {
        this.goodsImg = goodsImg;
    }

    public String getGoodsName() {
        return goodsName;
    }

    public void setGoodsName(String goodsName) {
        this.goodsName = goodsName;
    }

    public BigDecimal getGoodsPrice() {
        return goodsPrice;
    }

    public void setGoodsPrice(BigDecimal goodsPrice) {
        this.goodsPrice = goodsPrice;
    }

    public String getGoodsDesc() {
        return goodsDesc;
    }

    public void setGoodsDesc(String goodsDesc) {
        this.goodsDesc = goodsDesc;
    }

    public Integer getGoodsNum() {
        return goodsNum;
    }

    public void setGoodsNum(Integer goodsNum) {
        this.goodsNum = goodsNum;
    }

    public String getGoodsSendLocation() {
        return goodsSendLocation;
    }

    public void setGoodsSendLocation(String goodsSendLocation) {
        this.goodsSendLocation = goodsSendLocation;
    }

    public String getGoodsSource() {
        return goodsSource;
    }

    public void setGoodsSource(String goodsSource) {
        this.goodsSource = goodsSource;
    }

    public String getGoodsNo() {
        return goodsNo;
    }

    public void setGoodsNo(String goodsNo) {
        this.goodsNo = goodsNo;
    }

    public Integer getIsOnSale() {
        return isOnSale;
    }

    public void setIsOnSale(Integer isOnSale) {
        this.isOnSale = isOnSale;
    }

    public String getFirstCategory() {
        return firstCategory;
    }

    public void setFirstCategory(String firstCategory) {
        this.firstCategory = firstCategory;
    }

    public String getSecondCategory() {
        return secondCategory;
    }

    public void setSecondCategory(String secondCategory) {
        this.secondCategory = secondCategory;
    }

    public String getThirdCategory() {
        return thirdCategory;
    }

    public void setThirdCategory(String thirdCategory) {
        this.thirdCategory = thirdCategory;
    }
}
