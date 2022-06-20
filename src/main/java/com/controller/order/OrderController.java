package com.controller.order;

import com.common.BaseResponse;
import com.common.ailuenum.APICode;
import com.controller.order.req.OrderPageRequest;
import com.controller.order.req.OrderRequest;
import com.controller.order.res.OrderDetailResponse;
import com.controller.order.res.OrdersExcelResponse;
import com.define.exception.VerifyParameterException;
import com.entity.order.Order;
import com.github.pagehelper.PageInfo;
import com.mapper.IOrderMapper;
import com.service.order.IOrderService;
import com.until.*;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.util.Date;
import java.util.List;

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

    @Autowired
    private IOrderMapper orderMapper;

    private static final String fileName = "Order_list_"+ DateUtil.getStringDate(new Date(),"yyyy-MM-dd");

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

    @PostMapping("/deleteOrder")
    @ApiOperation("删除订单")
    @ResponseBody
    public BaseResponse<String> deleteOrderByOrderNo(@RequestParam String orderNo,@RequestParam Integer userId) throws VerifyParameterException {

        // check param
        if(StringUtils.isBlank(orderNo) || userId == null){
            throw new VerifyParameterException("删除订单缺少必传参数");        }

        // delete order
        orderService.deleteOrder(orderNo,userId);
        return BaseResponse.success(APICode.SUCCESS_DELETE_ORDER.getMessage());
    }

    @PostMapping("/exportOrdersExcel")
    @ApiOperation("导出订单excel")
    @ResponseBody
    public void exportOrdersExcel(@RequestBody OrderPageRequest req, HttpServletResponse res){

        // get orderList
        List<Order> orderList = orderMapper.queryOrdersPageByCondition(req);

        // check excel size
        AssertUtil.isTrue(orderList.size()>10000,"导出的订单信息太多，服务端不支持");

        // convert class
        List<OrdersExcelResponse> ordersExcelResponses = BeanUtil.copyBeanFromNewList(orderList, OrdersExcelResponse.class);
        for (int i = 0; i < ordersExcelResponses.size();i++){
            ordersExcelResponses.get(i).setIndex(i+1);
        }

        // export excel
        ExcelUtils.writeExcel(res,ordersExcelResponses,OrdersExcelResponse.class,fileName,"订单信息");
    }
}
