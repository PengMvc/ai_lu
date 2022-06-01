package com.common.ailuenum;

/**
 * @Author: PengMvc
 * @Date: 2022/06/01/21:06
 */
public enum PayEnum {

    ZFB(1,"支付宝"),
    WX(2,"微信"),
    YHK(3,"银行卡");

    private Integer code;

    private String name;

    PayEnum(Integer code, String name) {
        this.code = code;
        this.name = name;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public static String getPayName(Integer code){
        for (PayEnum value : PayEnum.values()) {
            if(value.getCode().equals(code)){
                return value.getName();
            }
        }
        throw new IllegalArgumentException("未知的支付类型"+code);
    }
}
