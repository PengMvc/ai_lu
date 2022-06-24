package com.service.order.evaluate.impl;

import com.common.ailuenum.APICode;
import com.common.ailuenum.OrderEnum;
import com.controller.order.req.OrderEvaluateRequest;
import com.define.exception.APIException;
import com.mapper.IOrderEvaluateMapper;
import com.service.order.evaluate.IOrderEvaluateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @Author: PengMvc
 * @Date: 2022/06/24/11:36
 */
@Service
public class OrderEvaluateServiceImpl implements IOrderEvaluateService {

    @Autowired
    IOrderEvaluateMapper orderEvaluateMapper;

    @Override
    public void evaluateOrder(OrderEvaluateRequest req) {

        // check order status
        if(!OrderEnum.WAIT_EVALUATE.getCode().equals(req.getOrderStatus())){
            throw new APIException(APICode.ORDER_INCORRECT_STATUS);
        }

        // evaluate order
        orderEvaluateMapper.evaluateOrder(req);
    }
}
