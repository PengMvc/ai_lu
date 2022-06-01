package com.controller.user.req;

import io.swagger.annotations.ApiModelProperty;

/**
 * 用户登录请求报文
 * @Author: PengMvc
 * @Date: 2022/05/24/18:51
 */
public class LoginRequest {

    @ApiModelProperty(value = "用户手机号",required = true)
    private String userPhone;

    @ApiModelProperty(value = "用户登陆密码",required = true)
    private String loginPwd;

    @ApiModelProperty(value = "用户验证码",required = true)
    private String verifyCode;

    public String getVerifyCode() {
        return verifyCode;
    }

    public void setVerifyCode(String verifyCode) {
        this.verifyCode = verifyCode;
    }

    public String getUserPhone() {
        return userPhone;
    }

    public void setUserPhone(String userPhone) {
        this.userPhone = userPhone;
    }

    public String getLoginPwd() {
        return loginPwd;
    }

    public void setLoginPwd(String loginPwd) {
        this.loginPwd = loginPwd;
    }
}
