package com.redis;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * redis配置类
 * @author PengMvc
 * @date 2022/5/23 15:27
 */
@Controller
public class RedisTest {
    @Autowired
    private RedisUtil redisUtil;

    @RequestMapping("/getRedisValue")
    @ResponseBody
    public String getRedisValue(){
        redisUtil.set("test","hello");
        return redisUtil.get("test");
    }
}
