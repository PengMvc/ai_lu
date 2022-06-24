package com.common.ailuenum;

/**
 * @Author: PengMvc
 * @Date: 2022/05/31/16:33
 */
public enum OrderEnum {

    NO_PAY(0,"未付款"),
    ALREADY_PAY(1,"已付款"),
    ALREADY_SHIP(2,"已发货"),
    ALREADY_SIGN(3,"已签收"),
    RETURN_GOODS_APPLY(4,"退货申请"),
    RETURNING_GOODS(5,"退货中"),
    ALREADY_RETURN_GOODS(6,"已经退货"),
    WAIT_EVALUATE(7,"待评价"),
    CANCEL_TRADING(-1,"取消交易")
    ;


    private Integer code;

    private String msg;

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    OrderEnum(Integer code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public static String getStatusMsg(Integer code){
        for (OrderEnum value : OrderEnum.values()) {
            if(value.getCode().equals(code)){
                return value.getMsg();
            }
        }
        throw new IllegalArgumentException("未知的订单状态"+code);
    }
}
