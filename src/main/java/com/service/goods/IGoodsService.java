package com.service.goods;

import com.controller.req.QueryGoodsRequest;
import com.entity.goods.Goods;
import com.github.pagehelper.PageInfo;

import java.util.List;

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
    public Goods queryGoodsDetail(Integer goodsNo);
}
