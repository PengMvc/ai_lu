package com.controller.order;

import com.common.BaseResponse;
import com.common.ailuenum.APICode;
import com.controller.order.req.OrderPageRequest;
import com.controller.order.req.OrderRequest;
import com.controller.order.res.OrderDetailResponse;
import com.define.exception.VerifyParameterException;
import com.entity.order.Order;
import com.github.pagehelper.PageInfo;
import com.service.order.IOrderService;
import com.until.StringUtils;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

/**
 * @Author: PengMvc
 * @Date: 2022/05/27/16:50
 */
@RequestMapping("/order")
@Api(tags = {"04.订单相关模块"})
@Controller
public class OrderController {

    @Autowired
    private IOrderService orderService;

    @PostMapping("/placeOrder")
    @ResponseBody
    @ApiOperation("用户下单接口")
    public BaseResponse<String> placeOrder(@RequestBody OrderRequest req) throws InterruptedException, VerifyParameterException {

        // check param
        if(req.getGoodsNo() ==null || req.getBuyNum() == null || req.getBuyNum()  <= 0){
            throw new VerifyParameterException("用户下单缺少必传参数");
        }
        orderService.placeOrder(req);
        return BaseResponse.success(APICode.SUCCESS_PLACE_ORDER.getMessage());
    }

    @ApiOperation("获取订单详情")
    @PostMapping("/getOrderDetail")
    @ResponseBody
    public BaseResponse<OrderDetailResponse> getOrderDetail(@RequestParam String orderNo, @RequestParam Integer userId) throws VerifyParameterException {

        // check param
        if(StringUtils.isBlank(orderNo) || userId == null){
            throw new VerifyParameterException("获取订单详情缺少必传参数");
        }

        // get orderDetail
        return BaseResponse.success(orderService.getOrderDetail(orderNo,userId));
    }

    @PostMapping("/getOrderListPage")
    @ApiOperation("按照条件查询订单信息分页展示")
    @ResponseBody
    public BaseResponse<PageInfo<Order>> getOrdersPageByCondition(@RequestBody OrderPageRequest req) throws VerifyParameterException {

        // check param
        if(req.getUserId() == null || req.getPageNo() ==null || req.getPageSize() ==null){
            throw new VerifyParameterException("查询订单信息缺少必传参数");
        }

        // get orderList
        return BaseResponse.success(orderService.getOrdersPageByCondition(req));
    }
}
