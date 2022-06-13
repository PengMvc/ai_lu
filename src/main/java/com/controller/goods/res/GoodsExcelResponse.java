package com.controller.goods.res;

import com.alibaba.excel.annotation.ExcelIgnore;
import com.alibaba.excel.annotation.ExcelProperty;
import io.swagger.annotations.ApiModelProperty;

import java.math.BigDecimal;

/**
 * @Author: PengMvc
 * @Date: 2022/06/10/17:33
 */
public class GoodsExcelResponse {

    @ApiModelProperty(value = "序号")
    @ExcelProperty(value = "序号",index = 0)
    private Integer index;

    @ApiModelProperty(value = "商品编号")
    @ExcelProperty(value ="商品编号" ,index = 1)
    private Integer goodsNo;

    @ApiModelProperty(value = "商品数量")
    @ExcelProperty(value ="商品数量" ,index = 4)
    private Integer goodsNum;

    @ApiModelProperty(value = "商品名称")
    @ExcelProperty(value ="商品名称" ,index = 2)
    private String goodsName;

    @ApiModelProperty(value = "商品价格")
    @ExcelProperty(value ="商品价格" ,index = 3)
    private BigDecimal goodsPrice;

    @ExcelIgnore
    private Integer isOnSale;

    @ApiModelProperty(value = "商品是否在售")
    @ExcelProperty(value ="商品是否在售" ,index = 6)
    private String isOnSale1;

    @ApiModelProperty(value = "商品描述")
    @ExcelProperty(value ="商品描述" ,index = 5)
    private String goodsDesc;

    public Integer getIndex() {
        return index;
    }

    public void setIndex(Integer index) {
        this.index = index;
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

    public Integer getIsOnSale() {
        return isOnSale;
    }

    public void setIsOnSale(Integer isOnSale) {
        this.isOnSale = isOnSale;
    }

    public String getIsOnSale1() {
        if(isOnSale == 0){
            return "商品不在售";
        }
        return "商品在售";
    }

    public void setIsOnSale1(String isOnSale1) {
        this.isOnSale1 = isOnSale1;
    }

    public String getGoodsDesc() {
        return goodsDesc;
    }

    public void setGoodsDesc(String goodsDesc) {
        this.goodsDesc = goodsDesc;
    }
}
