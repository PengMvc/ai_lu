package com.mapper;

import com.controller.order.req.OrderRequest;
import com.entity.order.Order;
import org.apache.ibatis.annotations.Param;


/**
 * @Author: PengMvc
 * @Date: 2022/05/30/20:30
 */
public interface IOrderMapper {

    public void createOrder(OrderRequest req);

    public Order getOrderDetail(@Param("orderNo") String orderNo,@Param("userId") Integer userId);
}
