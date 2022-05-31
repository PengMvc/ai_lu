package com.service.order.impl;

import com.common.ailuenum.APICode;
import com.controller.order.req.OrderRequest;
import com.define.exception.APIException;
import com.entity.goods.Goods;
import com.lock.AiLuLock;
import com.mapper.IGoodsMapper;
import com.mapper.IOrderMapper;
import com.service.order.IOrderService;
import org.redisson.api.RLock;
import org.redisson.api.RedissonClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * order serviceImpl
 * @Author: PengMvc
 * @Date: 2022/05/30/20:28
 */
@Service
public class OrderServiceImpl implements IOrderService {

    @Autowired
    private IOrderService orderService;

    @Autowired
    private RedissonClient redisson;

    @Autowired
    private IOrderMapper orderMapper;

    @Autowired
    private IGoodsMapper goodsMapper;

    @Override
    public void placeOrder(OrderRequest req) {

        // get lock obj
        RLock placeOrderLock = redisson.getLock(AiLuLock.PLACE_ORDER);

        // get lockFlag
        boolean lockFlag = placeOrderLock.isLocked();

        // check
        if(lockFlag){
            return;
        }

        try {
            // lock
            placeOrderLock.lock();

            // get order inventory from mysql
            Goods goods = goodsMapper.queryGoodsDetail(req.getGoodsNo());
            Integer remain = goods.getGoodsNum() - req.getBuyNum();
            if(remain < 0){
                throw new APIException(APICode.INVENTORY_SHORTAGE);
            }

            // create order
            orderMapper.createOrder(req);

            // update inventory
            goodsMapper.updateGoodsInfo(createGoodsData(req.getGoodsNo(),remain));
        } catch (APIException e) {
            throw new APIException(APICode.FAIL_PLACE_ORDER);
        }finally {
            placeOrderLock.unlock();
        }

    }

    private Goods createGoodsData(Integer goodsNo,Integer remainNum){
        Goods goods = new Goods();
        goods.setGoodsNum(remainNum);
        goods.setGoodsNo(goodsNo);
        return goods;
    }
}