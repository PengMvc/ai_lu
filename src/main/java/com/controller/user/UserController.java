package com.controller.user;

import com.common.BaseResponse;
import com.controller.user.req.RegisterRequest;
import com.define.exception.VerifyParameterException;
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

    @PostMapping("/login")
    @ApiOperation("用户登录")
    public Boolean userLogin(){
        return true;
    }

    @PostMapping("/userRegister")
    @ApiOperation("用户注册")
    @ResponseBody
    public BaseResponse<Void> userRegister(@RequestBody RegisterRequest req) throws VerifyParameterException {

        // 核心参数校验
        if(StringUtils.isBlank(req.getUserIdentityCard()) ||
                StringUtils.isBlank(req.getUserPhone()) || req.getLoginPwd() == null){
            throw new VerifyParameterException("用户注册缺少核心数据");
        }

        // 用户注册
        userService.userRegister(req);
        return BaseResponse.success();
    }
}


