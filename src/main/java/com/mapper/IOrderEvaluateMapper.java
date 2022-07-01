package com.mapper;

import com.controller.order.req.OrderEvaluatePageRequest;
import com.controller.order.req.OrderEvaluateRequest;
import com.entity.order.orderevaluate.OrderEvaluate;
import org.apache.ibatis.annotations.Param;
import org.apache.poi.ss.formula.functions.T;

import java.util.List;

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
    public Object getOrderEvaluateDetail(@Param("userId")Integer userId, @Param("orderNo") String orderNo);

    /**
     * 分页查询用户订单评价信息
     * @param req
     * @return 分页评价订单信息
     */
    public List<OrderEvaluate> queryOrderEvaluateList(OrderEvaluatePageRequest req);
}
