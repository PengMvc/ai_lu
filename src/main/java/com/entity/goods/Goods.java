package com.entity.goods;

import java.math.BigDecimal;

/**
 * commodity entity
 * @Author: PengMvc
 * @Date: 2022/05/26/11:26
 */
public class Goods {

    /**goods id*/
    private Integer goodsId;

    /**goods name*/
    private String goodsName;

    /**goods price*/
    private BigDecimal goodsPrice;

    /**goods first category*/
    private String firstCategory;

    /**goods second category*/
    private String secondCategory;

    /**goods third category*/
    private String thirdCategory;

    /**goods no*/
    private Integer goodsNo;

    /**goods num*/
    private Integer goodsNum;

    /**goods source*/
    private String goodsSource;

    /**is on sale (0:sale 1:not sale)*/
    private Integer isOnSale;

    /**goods description*/
    private String goodsDesc;

    /**goods send location*/
    private String goodsSendLocation;

    public Integer getGoodsId() {
        return goodsId;
    }

    public void setGoodsId(Integer goodsId) {
        this.goodsId = goodsId;
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

    public void setGoodsPrice(Float goodsPrice) {
        this.goodsPrice = BigDecimal.valueOf(goodsPrice);
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

    public Integer getGoodsNo() {
        return goodsNo;
    }

    public void setGoodsNo(Integer goodsNo) {
        this.goodsNo = goodsNo;
    }

    public Integer getGoodsNum() {
        return goodsNum;
    }

    public void setGoodsNum(Integer goodsNum) {
        this.goodsNum = goodsNum;
    }

    public String getGoodsSource() {
        return goodsSource;
    }

    public void setGoodsSource(String goodsSource) {
        this.goodsSource = goodsSource;
    }

    public Integer getIsOnSale() {
        return isOnSale;
    }

    public void setIsOnSale(Integer isOnSale) {
        this.isOnSale = isOnSale;
    }

    public String getGoodsDesc() {
        return goodsDesc;
    }

    public void setGoodsDesc(String goodsDesc) {
        this.goodsDesc = goodsDesc;
    }

    public String getGoodsSendLocation() {
        return goodsSendLocation;
    }

    public void setGoodsSendLocation(String goodsSendLocation) {
        this.goodsSendLocation = goodsSendLocation;
    }
}
