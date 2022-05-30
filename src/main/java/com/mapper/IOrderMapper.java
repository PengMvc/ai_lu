package com.mapper;

import com.controller.order.req.OrderRequest;


/**
 * @Author: PengMvc
 * @Date: 2022/05/30/20:30
 */
public interface IOrderMapper {

    public void createOrder(OrderRequest req);
}
