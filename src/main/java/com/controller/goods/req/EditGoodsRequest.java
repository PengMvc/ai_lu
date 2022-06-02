package com.controller.goods.req;

import io.swagger.annotations.ApiModelProperty;
import io.swagger.annotations.ApiOperation;

import java.math.BigDecimal;

/**
 * @Author: PengMvc
 * @Date: 2022/06/02/14:53
 */
public class EditGoodsRequest {

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

    @ApiModelProperty(value = "商品编号",required = true)
    private Integer goodsNo;

    public Integer getGoodsNo() {
        return goodsNo;
    }

    public void setGoodsNo(Integer goodsNo) {
        this.goodsNo = goodsNo;
    }

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
}
