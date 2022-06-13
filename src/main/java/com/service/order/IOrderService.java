package com.service.order;

import com.controller.order.req.OrderPageRequest;
import com.controller.order.req.OrderRequest;
import com.controller.order.res.OrderDetailResponse;
import com.entity.order.Order;
import com.github.pagehelper.PageInfo;

/**
 * order service
 * @Author: PengMvc
 * @Date: 2022/05/30/20:26
 */
public interface IOrderService {

    public void placeOrder(OrderRequest req);

    public OrderDetailResponse getOrderDetail(String orderNo, Integer userId);

    public PageInfo<Order> getOrdersPageByCondition(OrderPageRequest req);

    public void deleteOrder(String orderNo,Integer userId);
}