package com.controller.order.req;

/**
 * @Author: PengMvc
 * @Date: 2022/05/30/21:14
 */
public class OrderRequest {

    /**buy goods num*/
    private Integer buyNum;

    /**goods no*/
    private Integer goodsNo;

    public Integer getBuyNum() {
        return buyNum;
    }

    public void setBuyNum(Integer buyNum) {
        this.buyNum = buyNum;
    }

    public Integer getGoodsNo() {
        return goodsNo;
    }

    public void setGoodsNo(Integer goodsNo) {
        this.goodsNo = goodsNo;
    }
}
