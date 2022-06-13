package com.service.order.impl;

import com.common.ailuenum.APICode;
import com.common.ailuenum.LogisticsEnum;
import com.common.ailuenum.OrderEnum;
import com.common.ailuenum.PayEnum;
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
import com.service.order.IOrderService;
import com.service.user.impl.UserServiceImpl;
import com.until.BizNoGenerator;
import com.until.DateUtil;
import com.until.StringUtils;
import org.redisson.api.RLock;
import org.redisson.api.RedissonClient;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

/**
 * order serviceImpl
 * @Author: PengMvc
 * @Date: 2022/05/30/20:28
 */
@Service
public class OrderServiceImpl implements IOrderService {

    private static final Logger logger = LoggerFactory.getLogger(UserServiceImpl.class);

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
                logger.error("库存不足");
                throw new APIException(APICode.INVENTORY_SHORTAGE);
            }

            // create order
            orderMapper.createOrder(createOrderData(req,goods));

            // update inventory
            goodsMapper.updateGoodsInfo(createGoodsData(req.getGoodsNo(),remain));
        } catch (Exception e) {
            logger.error("下单失败");
            throw new APIException(APICode.FAIL_PLACE_ORDER);
        }finally {
            placeOrderLock.unlock();
        }

    }

    @Override
    public OrderDetailResponse getOrderDetail(String orderNo, Integer userId) {
        Order orderDetail = orderMapper.getOrderDetail(orderNo, userId);

        return createOrderDetailRes(orderDetail);
    }

    @Override
    public PageInfo<Order> getOrdersPageByCondition(OrderPageRequest req) {

        // init pageHelper
        PageHelper.startPage(req.getPageNo(),req.getPageSize());

        // get orderList
        List<Order> orderList = orderMapper.queryOrdersPageByCondition(req);

        // check
        if(CollectionUtils.isEmpty(orderList)){
            return new PageInfo<>();
        }
        return new PageInfo<Order>(orderList);
    }

    @Override
    public void deleteOrder(String orderNo, Integer userId) {
        orderMapper.deleteOrder(orderNo,userId);
    }

    private Goods createGoodsData(Integer goodsNo,Integer remainNum){
        Goods goods = new Goods();
        goods.setGoodsNum(remainNum);
        goods.setGoodsNo(goodsNo);
        return goods;
    }

    private OrderRequest createOrderData(OrderRequest req,Goods goods) {
        req.setCreateDate(DateUtil.formatDate(new Date(),"yyyy-MM-dd HH:mm:ss"));
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
