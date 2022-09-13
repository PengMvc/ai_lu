package com.controller.order;

import com.alibaba.fastjson.JSONObject;
import com.common.BaseResponse;
import com.controller.order.req.OrderRequest;
import com.util.BizNoGenerator;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

/**
 * @Author: PengMvc
 * @Date: 2022/09/13/10:33
 */
@RequestMapping("/AsyncPlaceOrder")
@Api(tags = {"07.异步订单接口"})
@Controller
public class AsyncOrderController {

    private static final Logger logger = LoggerFactory.getLogger(AsyncOrderController.class);

    @Autowired
    private KafkaTemplate kafkaTemplate;


    @ApiOperation("异步下单")
    @PostMapping("/SendOrderMsg")
    @ResponseBody
    public BaseResponse<Void> sendOrderMsg(@RequestParam String topic, @RequestBody OrderRequest req){

        req.setOrderNo(BizNoGenerator.getOrderNo(req.getOrderLogisticsId()));
        String orderMsg = JSONObject.toJSONString(req);
        kafkaTemplate.send(topic,orderMsg);
        logger.info("kafka发送订单信息的topic:{},orderMsg:{}",topic,orderMsg);

        return BaseResponse.success();
    }
}
