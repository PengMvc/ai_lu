package com.controller.user;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 客户登录接口
 * @Author PengMvc
 * @Date 2022/5/23 20:34
 **/
@Controller
@RequestMapping("/customer")
public class LoginController {

    @RequestMapping("/login")
    public Boolean customerLogin(){
        return true;
    }
}


