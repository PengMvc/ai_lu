package com.controller.user.req;

import io.swagger.annotations.ApiModelProperty;

/**
 * 注册请求报文
 * @Author: PengMvc
 * @Date: 2022/05/24/18:54
 */
public class UserRequest {

    /**用户姓名*/
    private String userName;

    /**用户手机*/
    @ApiModelProperty(value = "用户手机号")
    private String userPhone;

    @ApiModelProperty(value = "用户登陆密码")
    private String loginPwd;

    @ApiModelProperty(value = "用户性别(0：male 1:female)")
    private String sex;

    /**用户薪水*/
    @ApiModelProperty(hidden = true)
    private Integer salary;

    /**用户住址*/
    @ApiModelProperty(hidden = true)
    private String userAddress;

    @ApiModelProperty(value = "用户身份证")
    private String userIdentityCard;

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
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

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public Integer getSalary() {
        return salary;
    }

    public void setSalary(Integer salary) {
        this.salary = salary;
    }

    public String getUserAddress() {
        return userAddress;
    }

    public void setUserAddress(String userAddress) {
        this.userAddress = userAddress;
    }

    public String getUserIdentityCard() {
        return userIdentityCard;
    }

    public void setUserIdentityCard(String userIdentityCard) {
        this.userIdentityCard = userIdentityCard;
    }
}
