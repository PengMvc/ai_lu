package com.mapper;

import com.controller.order.req.OrderPageRequest;
import com.controller.order.req.OrderRequest;
import com.entity.order.Order;
import org.apache.ibatis.annotations.Param;

import java.util.List;


/**
 * @Author: PengMvc
 * @Date: 2022/05/30/20:30
 */
public interface IOrderMapper {

    public void createOrder(OrderRequest req);

    public Order getOrderDetail(@Param("orderNo") String orderNo,@Param("userId") Integer userId);

    /**
     * query orderList page by condition
     * @param req
     * @return orderList
     */
    public List<Order> queryOrdersPageByCondition(OrderPageRequest req);

    /**
     * delete order
     * @param orderNo
     * @param userId
     */
    public Long deleteOrder(@Param("orderNo") String orderNo,@Param("userId") Integer userId);
}
