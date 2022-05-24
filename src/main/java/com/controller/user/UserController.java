package com.controller.user;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 客户登录接口
 * @Author PengMvc
 * @Date 2022/5/23 20:34
 **/
@Controller
@RequestMapping("/customer")
@Api(tags = "02.用户相关接口")
public class UserController {

    @PostMapping("/login")
    @ApiOperation("用户登录")
    public Boolean userLogin(){
        return true;
    }

    @PostMapping("/userRegister")
    @ApiOperation("用户注册")
    public Boolean userRegister(){
        return true;
    }
}


