package com.controller.order.evaluate;

import com.common.BaseResponse;
import com.common.ailuenum.APICode;
import com.controller.order.req.OrderEvaluatePageRequest;
import com.controller.order.req.OrderEvaluateRequest;
import com.define.exception.VerifyParameterException;
import com.entity.order.orderevaluate.OrderEvaluate;
import com.github.pagehelper.PageInfo;
import com.service.order.evaluate.IOrderEvaluateService;
import com.util.StringUtils;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

/**
 * order evaluate
 * @Author: PengMvc
 * @Date: 2022/06/24/11:21
 */
@RequestMapping("/evaluate")
@Api(tags = "05.订单评价模块")
@Controller
public class OrderEvaluateController {

    @Autowired
    IOrderEvaluateService orderEvaluateService;

    @Autowired
    private KafkaTemplate kafkaTemplate;

    @ApiOperation("订单评价")
    @PostMapping("/evaluateOrder")
    @ResponseBody
    public BaseResponse<String> evaluateOrder(@RequestBody OrderEvaluateRequest req) throws VerifyParameterException {

        // check param
        if(StringUtils.isBlank(req.getOrderNo()) || req.getUserId() == null || req.getOrderStatus() ==null){
            throw new VerifyParameterException("评价订单缺少必传参数");
        }

        // evaluate order
        orderEvaluateService.evaluateOrder(req);
        return BaseResponse.success(APICode.SUCCESS_EVALUATE_ORDER.getMessage());
    }

    @ApiOperation("查看订单评价详情")
    @PostMapping("/evaluateOrderDetail")
    @ResponseBody
    public BaseResponse<Object> getOrderEvaluateDetail(@RequestParam Integer userId, @RequestParam String orderNo) throws VerifyParameterException {

        // check param
        if(userId == null ||StringUtils.isBlank(orderNo)){
            throw new VerifyParameterException("查询订单评价详情缺少必传参数");
        }

        // get orderEvaluateDetail
        return BaseResponse.success(orderEvaluateService.getOrderEvaluateDetail(userId,orderNo));
    }

    @ApiOperation("分页查看用户已评价订单信息")
    @PostMapping("/getEvaluateOrderPage")
    @ResponseBody
    public BaseResponse<PageInfo<OrderEvaluate>> queryOrderEvaluatePage(@RequestBody OrderEvaluatePageRequest req) throws VerifyParameterException {

        // check param
        if(req.getUserId() == null){
            throw new VerifyParameterException("查询用户已评价订单缺少必传参数");
        }

        // get evaluate order page
        return BaseResponse.success(orderEvaluateService.getOrderEvaluatePage(req));
    }


    @PostMapping("/sendGoodsMsg")
    @ApiOperation("发送商品信息")
    @ResponseBody
    public BaseResponse<Void> sendGoodsMsg(@RequestParam String topic, @RequestParam String msg ){
        kafkaTemplate.send(topic,msg);
        return BaseResponse.success();
    }
}
