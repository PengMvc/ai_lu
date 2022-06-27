package com.mapper;

import com.controller.order.req.OrderEvaluateRequest;
import com.entity.order.orderevaluate.OrderEvaluate;
import org.apache.ibatis.annotations.Param;

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

    /**
     * 查询订单评价详情
     * @param userId
     * @param orderNo
     * @return
     */
    public OrderEvaluate getOrderEvaluateDetail(@Param("userId")Integer userId,@Param("orderNo") String orderNo);
}
