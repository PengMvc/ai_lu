package com.common.ailuenum;

/**
 * @Author: PengMvc
 * @Date: 2022/06/01/20:44
 */
public enum LogisticsEnum {


    SFWL(1,"顺丰物流"),
    JDWL(2,"京东物流"),
    ZTWL(3,"中通物流"),
    STWL(4,"申通物流"),
    YTWL(5,"圆通物流"),
    YDWL(6,"韵达物流");

    private Integer code;

    private String name;

    LogisticsEnum(Integer code, String name) {
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

    public static String getNameByCode(Integer code){
        for (LogisticsEnum value : LogisticsEnum.values()) {
            if(value.getCode().equals(code)){
                return value.getName();
            }
        }
        throw new IllegalArgumentException("未知的物流类型"+code);
    }
}
