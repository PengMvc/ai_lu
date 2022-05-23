package com.controller.verification.code;

import com.constant.CacheKeyConstant;
import com.define.exception.VerifyParameterException;
import com.redis.RedisUtil;
import com.until.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Random;

/**
 * 获取验证码
 * @Author PengMvc
 * @Date 2022/5/23 22:13
 **/
@Controller
@RequestMapping("/verification")
public class VerificationCodeController {

    @Autowired
    RedisUtil redisUtil;

    @RequestMapping("/getVerificatinCode")
    @ResponseBody
    public String getVerificatinCode(@RequestParam String userPhone) throws VerifyParameterException {

        // 参数校验
        if(StringUtils.isBlank(userPhone)){
            throw new VerifyParameterException("参数校验异常！");
        }

        // 拼接key
        String verrifyKey = CacheKeyConstant.USER_VERIFY_KEY+userPhone;

        // 生成验证码
        String code = generateCode();

        // 验证码入redis,设置过期时间5分钟
        redisUtil.set(verrifyKey,code,5000);

        return code;
    }

    private String generateCode(){
        Random random = new Random();
        String code="";
        for(int i=0;i<6;i++){
            //生成10以内的10位数随机整数
            int rand = random.nextInt(10);
            //拼接随机数
            code+=rand;
        }
        return  code ;
    }
}


