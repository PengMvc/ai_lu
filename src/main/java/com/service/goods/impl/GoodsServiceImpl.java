package com.service.goods.impl;

import com.alibaba.fastjson.JSON;
import com.common.ailuenum.APICode;
import com.common.topic.AiluTopics;
import com.constant.CacheKeyConstant;
import com.controller.goods.req.AddGoodsRequest;
import com.controller.goods.req.EditGoodsRequest;
import com.controller.goods.req.QueryGoodsRequest;
import com.define.exception.APIException;
import com.entity.goods.Goods;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.mapper.IGoodsMapper;
import com.redis.RedisUtil;
import com.service.goods.IGoodsService;
import com.until.BizNoGenerator;
import com.until.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;
import springfox.documentation.spring.web.json.Json;

import java.util.List;

/**
 * @Author: PengMvc
 * @Date: 2022/05/26/16:51
 */
@Service
@Transactional(rollbackFor = Exception.class)
public class GoodsServiceImpl implements IGoodsService {

    @Autowired
    private IGoodsMapper goodsMapper;

    @Autowired
    private RedisUtil redisUtil;

    @Autowired
    private KafkaTemplate kafkaTemplate;

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

        // cache goods key
        String goodsKey = CacheKeyConstant.GOODS_DETAIL+goodsNo;

        // check redis if exist goods detail
        String goodsString = redisUtil.get(goodsKey);
        if(!StringUtils.isBlank(goodsString)){
            return JSON.parseObject(goodsString, Goods.class);
        }

        // query goods from redis
        Goods goods = goodsMapper.queryGoodsDetail(goodsNo);

        // cache goodsDetail one month
        redisUtil.set(goodsKey, JSON.toJSONString(goods),431200);
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

        // send msg to ai_lu_msgx
        kafkaTemplate.send(AiluTopics.AI_LU_GOODS,req);
    }

    @Override
    public void deleteGoodsInfo(String goodsNo) {
        Long deleteNum = goodsMapper.deleteGoodsInfo(goodsNo);
        if(deleteNum!=1){
            throw new APIException(APICode.FAIL_DELETE_GOODS);
        }
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
