package com.service.order.impl;

import com.alibaba.fastjson.JSON;
import com.common.ailuenum.APICode;
import com.common.ailuenum.LogisticsEnum;
import com.common.ailuenum.OrderEnum;
import com.common.ailuenum.PayEnum;
import com.constant.CacheKeyConstant;
import com.controller.order.req.OrderEditRequest;
import com.controller.order.req.OrderPageRequest;
import com.controller.order.req.OrderRequest;
import com.controller.order.res.OrderDetailResponse;
import com.define.exception.APIException;
import com.entity.goods.Goods;
import com.entity.order.Order;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.lock.AiLuLock;
import com.mapper.IGoodsMapper;
import com.mapper.IOrderMapper;
import com.redis.RedisUtil;
import com.service.order.IOrderService;
import com.service.user.impl.UserServiceImpl;
import com.util.BizNoGenerator;
import com.util.DateUtils;
import com.util.StringUtils;
import org.redisson.api.RLock;
import org.redisson.api.RedissonClient;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.math.BigDecimal;
import java.text.ParseException;
import java.util.Date;
import java.util.List;

/**
 * order serviceImpl
 * @Author: PengMvc
 * @Date: 2022/05/30/20:28
 */
@Service
public class OrderServiceImpl implements IOrderService {

    private static final Logger logger = LoggerFactory.getLogger(OrderServiceImpl.class);
    private static final String DATE_FORMATE = "yyyy-MM-dd HH:mm:ss";

    @Autowired
    private IOrderService orderService;

    @Autowired
    private RedissonClient redisson;

    @Autowired
    private IOrderMapper orderMapper;

    @Autowired
    private IGoodsMapper goodsMapper;

    @Autowired
    private RedisUtil redisUtil;

    @Override
    public void placeOrder(OrderRequest req) {

        // get goodsNo
        String goodsNo = req.getGoodsNo();

        // check param
        if(StringUtils.isBlank(goodsNo)){
            throw new APIException(APICode.GOODS_NO_IS_EMPTY);
        }

        // get lock obj
        RLock placeOrderLock = redisson.getLock(AiLuLock.PLACE_ORDER+goodsNo);

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
            Goods goods = goodsMapper.queryGoodsDetail(goodsNo);
            Integer remain = goods.getGoodsNum() - req.getBuyNum();
            if(remain < 0){
                logger.error("库存不足");
                throw new APIException(APICode.INVENTORY_SHORTAGE);
            }

            // create order
            orderMapper.createOrder(createOrderData(req,goods));

            // update inventory
            goodsMapper.updateGoodsInfo(createGoodsData(goodsNo,remain));
        } catch (Exception e) {
            logger.error("下单失败");
            throw new APIException(APICode.FAIL_PLACE_ORDER);
        }finally {
            placeOrderLock.unlock();
        }
    }

    @Override
    public OrderDetailResponse getOrderDetail(String orderNo, Integer userId) throws ParseException {

        // order key
        String orderKey = CacheKeyConstant.ORDER_DETAIL + userId +"_"+orderNo;
        String strOrderDetail = redisUtil.get(orderKey);

        // check if exist orderDetail in cache
        if(!StringUtils.isBlank(strOrderDetail)){
            return createOrderDetailRes(JSON.parseObject(strOrderDetail,Order.class));
        }

        // query orderDetail from db
        Order orderDetail = orderMapper.getOrderDetail(orderNo, userId);

        // store to cahce
        redisUtil.set(orderKey,JSON.toJSONString(orderDetail),DateUtils.calculateTwoDateSecond(new Date(),DateUtils.nextEffectiveDate(new Date(),DATE_FORMATE)));
        return createOrderDetailRes(orderDetail);
    }

    @Override
    public PageInfo<Order> getOrdersPageByCondition(OrderPageRequest req) {

        // init pageHelper
        PageHelper.startPage(req.getPageNo(),req.getPageSize());

        // get orderList
        List<Order> orderList = orderMapper.queryOrdersPageByCondition(req);

        // check orderList
        if(CollectionUtils.isEmpty(orderList)){
            return new PageInfo<>();
        }
        return new PageInfo<Order>(orderList);
    }

    @Override
    public void deleteOrder(String orderNo, Integer userId) {
        Long deleteNum = orderMapper.deleteOrder(orderNo, userId);
        if(deleteNum != 1){
            throw new APIException(APICode.FAIL_DELETE_ORDER);
        }
    }

    @Override
    public void editOrder(OrderEditRequest req) {
        orderMapper.editOrder(req);
    }

    private Goods createGoodsData(String goodsNo,Integer remainNum){
        Goods goods = new Goods();
        goods.setGoodsNum(remainNum);
        goods.setGoodsNo(goodsNo);
        return goods;
    }

    private OrderRequest createOrderData(OrderRequest req,Goods goods) {
        req.setCreateDate(DateUtils.formatDate(new Date(),"yyyy-MM-dd HH:mm:ss"));
        BigDecimal goodsTotalPrice = goods.getGoodsPrice().multiply(new BigDecimal(req.getBuyNum()));
        req.setOrderTotalPrice(goodsTotalPrice.add(req.getLogisticsFee()));
        req.setGoodsTotalPrice(goodsTotalPrice);
        req.setOrderNo(BizNoGenerator.getOrderNo(req.getOrderLogisticsId()));
        req.setOrderStatus(OrderEnum.NO_PAY.getCode());
        req.setGoodsName(goods.getGoodsName());
        return req;
    }

    public OrderDetailResponse createOrderDetailRes(Order orderDetail){
        OrderDetailResponse orderDetailRes = new OrderDetailResponse();
        orderDetailRes.setCreateDate(orderDetail.getCreateDate());
        orderDetailRes.setOrderNo(orderDetail.getOrderNo());
        orderDetailRes.setGoodsName(orderDetail.getGoodsName());
        orderDetailRes.setBuyNum(orderDetail.getBuyNum());
        orderDetailRes.setOrderStatus(OrderEnum.getStatusMsg(orderDetail.getOrderStatus()));
        orderDetailRes.setUserName(orderDetail.getUserName());
        orderDetailRes.setGoodsTotalPrice(orderDetail.getGoodsTotalPrice());
        orderDetailRes.setOrderTotalPrice(orderDetail.getOrderTotalPrice());
        orderDetailRes.setLogisticsName(LogisticsEnum.getNameByCode(orderDetail.getOrderLogisticsId()));
        orderDetailRes.setShippingAddress(orderDetail.getShippingAddress());
        orderDetailRes.setUserComment(orderDetail.getUserComment());
        orderDetailRes.setLogisticsFee(orderDetail.getLogisticsFee());
        orderDetailRes.setShopId(orderDetail.getShopId());
        orderDetailRes.setPayChannel(PayEnum.getPayName(orderDetail.getPayChannel()));
        return orderDetailRes;
    }
}
