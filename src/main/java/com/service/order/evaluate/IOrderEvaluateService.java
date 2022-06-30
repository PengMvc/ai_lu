package com.service.order.evaluate;

import com.controller.order.req.OrderEvaluateRequest;
import com.entity.order.orderevaluate.OrderEvaluate;
import org.apache.poi.ss.formula.functions.T;

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

    /**
     * get evaluate detail
     * @param userId
     * @param orderNo
     * @return
     */
    public Object getOrderEvaluateDetail(Integer userId, String orderNo);

}
