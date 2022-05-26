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
     * @return
     */
    public PageInfo<Goods> queryGoodsListPage(QueryGoodsRequest req);
}
