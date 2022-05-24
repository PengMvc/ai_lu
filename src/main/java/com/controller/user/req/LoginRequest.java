package com.controller.user.req;

/**
 * 用户登录请求报文
 * @Author: PengMvc
 * @Date: 2022/05/24/18:51
 */
public class LoginRequest {

    /**用户手机*/
    private String userPhone;

    /**登录密码*/
    private String loginPwd;

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
