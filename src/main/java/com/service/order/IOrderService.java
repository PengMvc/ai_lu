package com.service.order;

import com.controller.order.req.OrderRequest;
import com.controller.order.res.OrderDetailResponse;
import com.entity.order.Order;

/**
 * order service
 * @Author: PengMvc
 * @Date: 2022/05/30/20:26
 */
public interface IOrderService {

    public void placeOrder(OrderRequest req);

    public OrderDetailResponse getOrderDetail(String orderNo, Integer userId);
}
