package com.mapper;

import com.controller.order.req.OrderEvaluateRequest;

/**
 * @Author: PengMvc
 * @Date: 2022/06/24/11:51
 */
public interface IOrderEvaluateMapper {

    /**
     * 订单评价
     * @param req
     */
    public void evaluateOrder(OrderEvaluateRequest req);
}
