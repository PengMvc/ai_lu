package com.service.order.evaluate;

import com.controller.order.req.OrderEvaluateRequest;

/**
 * @Author: PengMvc
 * @Date: 2022/06/24/11:35
 */
public interface IOrderEvaluateService {

    /**
     * evaluate order
     * @param req
     */
    public void evaluateOrder(OrderEvaluateRequest req);
}
