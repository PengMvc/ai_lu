package com.controller.goods.req;

import com.common.PageRequest;
import io.swagger.annotations.ApiModelProperty;

import java.math.BigDecimal;

/**
 * query goods by condition
 * @Author: PengMvc
 * @Date: 2022/05/26/16:16
 */
public class QueryGoodsRequest extends PageRequest {

    @ApiModelProperty(value = "商品名称")
    private String goodsName;

    @ApiModelProperty(value = "商品价格区间最低价")
    private BigDecimal goodsPrice1;

    @ApiModelProperty(value = "商品价格区间最高价")
    private BigDecimal goodsPrice2;

    @ApiModelProperty(value = "商品一级分类")
    private String firstCategory;

    @ApiModelProperty(value = "商品二级分类")
    private String secondCategory;

    @ApiModelProperty(value = "商品三级分类")
    private String thirdCategory;

    @ApiModelProperty(value = "商品是否在售")
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
