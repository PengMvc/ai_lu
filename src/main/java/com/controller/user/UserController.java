package com.controller.user;

import com.common.BaseResponse;
import com.controller.user.req.EditUserRequest;
import com.controller.user.req.LoginRequest;
import com.controller.user.req.UserRequest;
import com.define.exception.VerifyParameterException;
import com.entity.user.User;
import com.service.user.IUserService;
import com.until.StringUtils;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;


/**
 * 用户相关接口
 * @Author PengMvc
 * @Date 2022/5/23 20:34
 **/
@Controller
@RequestMapping("/customer")
@Api(tags = "02.用户相关接口")
public class UserController {

    @Autowired
    private IUserService userService;

    @PostMapping("/userRegister")
    @ApiOperation("用户注册")
    @ResponseBody
    public BaseResponse<Void> userRegister(@RequestBody UserRequest req) throws VerifyParameterException {

        // 核心参数校验
        if(StringUtils.isBlank(req.getUserIdentityCard()) ||
                StringUtils.isBlank(req.getUserPhone()) || req.getLoginPwd() == null){
            throw new VerifyParameterException("用户注册缺少核心数据");
        }

        // 用户注册
        userService.userRegister(req);
        return BaseResponse.success();
    }

    @PostMapping("/userLogin")
    @ApiOperation("用户登录")
    @ResponseBody
    public BaseResponse<Void> userLogin(@RequestBody LoginRequest req) throws VerifyParameterException {
        // 登录核心参数校验
        if(StringUtils.isBlank(req.getVerifyCode()) ||
                StringUtils.isBlank(req.getUserPhone()) || StringUtils.isBlank(req.getLoginPwd())){
            throw new VerifyParameterException("用户注册缺少核心数据");
        }

        // 用户登录
        userService.userLogin(req);
        return BaseResponse.success();
    }

    @PostMapping("/editUserInfo")
    @ApiOperation("修改收货地址和密码")
    @ResponseBody
    public BaseResponse<Void>  editSingleUserInfo(@RequestBody EditUserRequest req) throws VerifyParameterException {

        // check necessary data
        if(StringUtils.isBlank(req.getUserAddress()) || StringUtils.isBlank(req.getLoginPwd())){
            throw new VerifyParameterException("修改用户信息，缺少必传参数");
        }

        // 修改用户信息
        userService.editUserInfo(req);
        return BaseResponse.success();
    }
}


