package com.define.exception;


import com.common.ailuenum.APICode;
/**
 * api Exception
 * @Author PengMvc
 * @Date 2022/5/24 23:54
 **/
public class APIException extends RuntimeException {

    private static final long serialVersionUID = 3375558717887911440L;
    
    private Integer code;
    private String message;
    private Object data;

    public APIException() {
        super();
    }

    public APIException(Integer code, String message) {
        super();
        this.code = code;
        this.message = message;
    }


    public APIException(Integer code, String message, Object data) {
        super();
        this.code = code;
        this.message = message;
        this.data = data;
    }
    
    public APIException(APICode apiCode) {
        this(apiCode.getCode(), apiCode.getMessage());
    }

    public APIException(APICode apiCode, String message) {
        this(apiCode.getCode(), message);
    }

    public APIException(APICode apiCode, String message, Object data) {
        this(apiCode.getCode(), message, data);
    }


    public Integer getCode() {
        return this.code;
    }

    @Override
    public String getMessage() {
        return this.message;
    }

    public Object getData() {
        return this.data;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public void setData(Object data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return "APIException(code=" + this.getCode() + ", message=" + this.getMessage() + ", data=" + this.getData() + ")";
    }
}
