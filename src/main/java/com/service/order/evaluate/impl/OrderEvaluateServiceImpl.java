package com.service.order.evaluate.impl;

import com.common.ailuenum.APICode;
import com.common.ailuenum.OrderEnum;
import com.controller.order.req.OrderEditRequest;
import com.controller.order.req.OrderEvaluateRequest;
import com.define.exception.APIException;
import com.entity.order.Order;
import com.mapper.IOrderEvaluateMapper;
import com.mapper.IOrderMapper;
import com.service.order.evaluate.IOrderEvaluateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @Author: PengMvc
 * @Date: 2022/06/24/11:36
 */
@Transactional(rollbackFor=Exception.class)
@Service
public class OrderEvaluateServiceImpl implements IOrderEvaluateService {

    @Autowired
    IOrderEvaluateMapper orderEvaluateMapper;

    @Autowired
    IOrderMapper orderMapper;

    @Override
    public void evaluateOrder(OrderEvaluateRequest req) {

        // check order status
        if(!OrderEnum.WAIT_EVALUATE.getCode().equals(req.getOrderStatus())){
            throw new APIException(APICode.ORDER_INCORRECT_STATUS);
        }

        // evaluate order
        orderEvaluateMapper.evaluateOrder(req);

        // update order status
        orderMapper.editOrder(packageReq(req));
    }

    public Object getOrderEvaluateDetail(Integer userId, String orderNo) {

        // get order detail
        Order orderDetail = orderMapper.getOrderDetail(orderNo, userId);
        if(OrderEnum.WAIT_EVALUATE.getCode().equals(orderDetail.getOrderStatus())){
            return orderDetail;
        }
        return orderEvaluateMapper.getOrderEvaluateDetail(userId,orderNo);
    }

    private OrderEditRequest packageReq(OrderEvaluateRequest req){
        OrderEditRequest editReq = new OrderEditRequest();
        editReq.setOrderNo(req.getOrderNo());
        editReq.setUserId(req.getUserId());
        editReq.setOrderStatus(OrderEnum.ALREADY_EVALUATE.getCode());
        return editReq;
    }
}
