package com.controller.kafka;

import com.common.BaseResponse;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * kafka producer
 * @Author: PengMvc
 * @Date: 2022/07/08/17:22
 */
@Api(tags = {"06.kafka推送数据"})
@Controller
@RequestMapping("/sendMsg")
public class ProducerController {

    private static final Logger logger = LoggerFactory.getLogger(ProducerController.class);

    @Autowired
    private KafkaTemplate kafkaTemplate;

    @PostMapping("/sendGoodsMsg")
    @ApiOperation("发送商品信息")
    @ResponseBody
    public BaseResponse<Void> sendGoodsMsg(@RequestParam String topic, @RequestParam String msg ){
        kafkaTemplate.send(topic,msg);
        logger.info("kafka发送商品信息topic:"+topic+"发送的消息:"+msg);
        return BaseResponse.success();
    }
}
