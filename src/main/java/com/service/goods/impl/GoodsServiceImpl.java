package com.service.goods.impl;

import com.controller.goods.req.AddGoodsRequest;
import com.controller.goods.req.EditGoodsRequest;
import com.controller.goods.req.QueryGoodsRequest;
import com.entity.goods.Goods;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.mapper.IGoodsMapper;
import com.service.goods.IGoodsService;
import com.until.BizNoGenerator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.List;

/**
 * @Author: PengMvc
 * @Date: 2022/05/26/16:51
 */
@Service
public class GoodsServiceImpl implements IGoodsService {

    @Autowired
    private IGoodsMapper goodsMapper;

    @Override
    public PageInfo<Goods> queryGoodsListPage(QueryGoodsRequest req) {

        // set pageHelper
        PageHelper.startPage(req.getPageNo(),req.getPageSize());

        // get goodsList
        List<Goods> goodsList = goodsMapper.queryGoodsPage(req);

        if(CollectionUtils.isEmpty(goodsList)){
            return new PageInfo<>();
        }
        return new PageInfo<>(goodsList);
    }

    @Override
    public Goods queryGoodsDetail(Integer goodsNo) {
        Goods goods = goodsMapper.queryGoodsDetail(goodsNo);
        return goods;
    }

    @Override
    public void editGoodsInfo(EditGoodsRequest req) {
        goodsMapper.updateGoodsInfo(createEditGoodsData(req));
    }

    @Override
    public void addGoodsInfo(AddGoodsRequest req) {
        // set goodsNo
        req.setGoodsNo(BizNoGenerator.getUniqueValue());
        goodsMapper.addGoodsInfo(req);
    }

    private Goods createEditGoodsData(EditGoodsRequest req){
        Goods goods = new Goods();
        goods.setGoodsNo(req.getGoodsNo());
        goods.setGoodsNum(req.getGoodsNum());
        goods.setGoodsDesc(req.getGoodsDesc());
        goods.setGoodsPrice(req.getGoodsPrice());
        goods.setGoodsSendLocation(req.getGoodsSendLocation());
        goods.setGoodsSource(req.getGoodsSource());
        goods.setGoodsImg(req.getGoodsImg());
        goods.setGoodsName(req.getGoodsName());
        return goods;
    }
}
