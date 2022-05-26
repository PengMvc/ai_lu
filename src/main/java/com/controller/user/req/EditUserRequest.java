package com.controller.user.req;

/**
 * edit userRequest
 * mainly pwd and address
 * @Author: PengMvc
 * @Date: 2022/05/26/10:07
 */
public class EditUserRequest {

    /**login password*/
    private String loginPwd;

    /**user shipping address*/
    private String userAddress;

    /**user identityCard*/
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
