package com.service.goods;

import com.controller.goods.req.AddGoodsRequest;
import com.controller.goods.req.EditGoodsRequest;
import com.controller.goods.req.QueryGoodsRequest;
import com.entity.goods.Goods;
import com.github.pagehelper.PageInfo;

/**
 * @Author: PengMvc
 * @Date: 2022/05/26/16:49
 */
public interface IGoodsService {

    /**
     * 根据条件查询商品信息
     * @param req
     * @return 商品集合
     */
    public PageInfo<Goods> queryGoodsListPage(QueryGoodsRequest req);

    /**
     * 查询商品详情
     * @param goodsNo
     * @return
     */
    public Goods queryGoodsDetail(String goodsNo);

    /**
     * 修改商品信息
     * @param req
     */
    public void editGoodsInfo(EditGoodsRequest req);

    /**
     * add single goods
     * @param req
     */
    public void addGoodsInfo(AddGoodsRequest req);

    /**
     * delete single goods
     * @param goodsNo
     */
    public void deleteGoodsInfo(String goodsNo);
}
