package com.service.order;

import com.controller.order.req.OrderRequest;

/**
 * order service
 * @Author: PengMvc
 * @Date: 2022/05/30/20:26
 */
public interface IOrderService {

    public void placeOrder(OrderRequest req);
}
