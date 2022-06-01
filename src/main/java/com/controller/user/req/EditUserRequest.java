package com.controller.user.req;

import io.swagger.annotations.ApiModelProperty;

/**
 * edit userRequest
 * mainly pwd and address
 * @Author: PengMvc
 * @Date: 2022/05/26/10:07
 */
public class EditUserRequest {

    @ApiModelProperty(value="用户登录密码")
    private String loginPwd;

    @ApiModelProperty(value="用户登录地址")
    private String userAddress;

    @ApiModelProperty(value="用户身份者号" ,required = true)
    private String userIdentityCard;

    public String getUserIdentityCard() {
        return userIdentityCard;
    }

    public void setUserIdentityCard(String userIdentityCard) {
        this.userIdentityCard = userIdentityCard;
    }

    public String getLoginPwd() {
        return loginPwd;
    }

    public void setLoginPwd(String loginPwd) {
        this.loginPwd = loginPwd;
    }

    public String getUserAddress() {
        return userAddress;
    }

    public void setUserAddress(String userAddress) {
        this.userAddress = userAddress;
    }
}
