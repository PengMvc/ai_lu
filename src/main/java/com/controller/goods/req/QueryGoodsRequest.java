package com.controller.goods.req;

import com.common.PageRequest;

import java.math.BigDecimal;

/**
 * query goods by condition
 * @Author: PengMvc
 * @Date: 2022/05/26/16:16
 */
public class QueryGoodsRequest extends PageRequest {

    /**goods name*/
    private String goodsName;

    /**goods price1*/
    private BigDecimal goodsPrice1;

    /**goods price2*/
    private BigDecimal goodsPrice2;

    /**goods first category*/
    private String firstCategory;

    /**goods second category*/
    private String secondCategory;

    /**goods third category*/
    private String thirdCategory;

    /**is on sale or not*/
    private Integer isOnSale;

    public Integer getIsOnSale() {
        return isOnSale;
    }

    public void setIsOnSale(Integer isOnSale) {
        this.isOnSale = isOnSale;
    }

    public String getGoodsName() {
        return goodsName;
    }

    public void setGoodsName(String goodsName) {
        this.goodsName = goodsName;
    }

    public BigDecimal getGoodsPrice1() {
        return goodsPrice1;
    }

    public void setGoodsPrice1(BigDecimal goodsPrice1) {
        this.goodsPrice1 = goodsPrice1;
    }

    public BigDecimal getGoodsPrice2() {
        return goodsPrice2;
    }

    public void setGoodsPrice2(BigDecimal goodsPrice2) {
        this.goodsPrice2 = goodsPrice2;
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
