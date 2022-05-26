package com.common.ailuenum;

/**
 * 响应码和信息
 * @Author PengMvc
 * @Date 2022/5/24 12:11
 **/
public enum APICode {

    SUCCESS(200,"请求成功"),

    /***********************600-700用户相关**********************/
    REPEAT_REGISTER(600,"重复注册"),
    FAIL_REGISTER(601,"注册失败"),
    VERITY_CODE_WRONG(602,"验证码错误"),
    FAIL_LOGIN(603,"登录失败"),
    NOT_REGISTER(604,"该用户还未注册"),
    FAIL_EDIT_USER(605,"修改用户信息失败");


    /**响应码*/
    private Integer code;

    /**响应信息*/
    private String message;

    APICode(Integer code, String message) {
        this.code = code;
        this.message = message;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}


