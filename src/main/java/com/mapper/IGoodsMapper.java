package com.mapper;

import com.controller.goods.req.QueryGoodsRequest;
import com.entity.goods.Goods;

import java.util.List;

/**
 * @Author: PengMvc
 * @Date: 2022/05/26/17:01
 */
public interface IGoodsMapper {

    /**
     * query goods by  condition (page)
     * @param req
     * @return
     */
    public List<Goods> queryGoodsPage(QueryGoodsRequest req);

    /**
     * query goods detail
     * @param goodNo
     * @return goods
     */
    public Goods queryGoodsDetail(Integer goodNo);
}
