package com.common.ailuenum;

/**
 * 响应码和信息
 * @Author PengMvc
 * @Date 2022/5/24 12:11
 **/
public enum APICode {

    SUCCESS(200,"请求成功"),

    /***********************600-699用户相关**********************/
    REPEAT_REGISTER(600,"重复注册"),
    FAIL_REGISTER(601,"注册失败"),
    VERITY_CODE_WRONG(602,"验证码错误"),
    FAIL_LOGIN(603,"登录失败"),
    NOT_REGISTER(604,"该用户还未注册"),
    FAIL_EDIT_USER(605,"修改用户信息失败"),

    /**********************700-799订单相关****************************/
    INVENTORY_SHORTAGE(700,"库存不足"),
    FAIL_PLACE_ORDER(701,"用户下单失败"),
    NOT_SUPPORT_L0GISTICS_MODE(702,"不支持该物流方式"),
    SUCCESS_PLACE_ORDER(703,"恭喜您下单成功"),
    SUCCESS_DELETE_ORDER(704,"删除订单成功"),
    FAIL_DELETE_ORDER(705,"删除订单失败"),
    SUCCESS_EVALUATE_ORDER(706,"评价订单成功"),
    ORDER_INCORRECT_STATUS(707,"订单状态不对，不能进行评价"),

    /*********************800-899商品相关****************************/
    SUCCESS_EDIT_GOODSINFO(800,"修改商品信息成功"),
    SUCCESS_ADD_GOODSINFO(801,"新增商品信息成功"),
    SUCCESS_DELETE_GOODS(802,"删除商品信息成功"),
    FAIL_DELETE_GOODS(803,"删除商品信息失败")
    ;
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


