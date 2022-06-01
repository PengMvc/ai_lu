package com.controller.user.req;

import io.swagger.annotations.ApiModelProperty;

/**
 * 注册请求报文
 * @Author: PengMvc
 * @Date: 2022/05/24/18:54
 */
public class UserRequest {

    @ApiModelProperty(value = "用户姓名",required = true)
    private String userName;

    @ApiModelProperty(value = "用户手机号",required = true)
    private String userPhone;

    @ApiModelProperty(value = "用户登陆密码",required = true)
    private String loginPwd;

    @ApiModelProperty(value = "用户性别(0：male 1:female)")
    private String sex;

    @ApiModelProperty(hidden = true,value = "用户薪水")
    private Integer salary;

    @ApiModelProperty(hidden = true,value = "用户住址")
    private String userAddress;

    @ApiModelProperty(value = "用户身份证",required = true)
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
