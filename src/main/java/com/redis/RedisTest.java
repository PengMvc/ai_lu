package com.redis;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * just for test redis
 */
@Controller
public class RedisTest {
    @Autowired
    private RedisUtil redisUtil;

    @RequestMapping("/getRedisValue")
    public void getRedisValue(){
        String userName = (String) redisUtil.get("userName");
        System.out.println("从redis取得值"+userName);
    }
}
