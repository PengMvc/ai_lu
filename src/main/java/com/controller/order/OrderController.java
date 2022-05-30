package com.controller.order;

import com.common.BaseResponse;
import com.controller.order.req.OrderRequest;
import com.define.exception.VerifyParameterException;
import com.service.order.IOrderService;
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
@Api(tags = {"04.订单相关接口"})
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
        return BaseResponse.success();
    }
}
