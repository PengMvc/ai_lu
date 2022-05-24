package com.common;

import com.common.ailuenum.APICode;

/**
 * 基础响应接口
 * @Author PengMvc
 * @Date 2022/5/24 10:26
 **/
public class BaseResponse<T> {

    /**响应码*/
    private Integer code;

    /**响应信息*/
    private String message;

    /**响应数据*/
    private T data;

    public BaseResponse() {
    }

    public BaseResponse(Integer code, String message) {
        this.code = code;
        this.message = message;
    }

    public BaseResponse(Integer code, String message, T data) {
        this.code = code;
        this.message = message;
        this.data = data;
    }

    public static <T> BaseResponseBuilder<T> builder() {
        return new BaseResponseBuilder<T>();
    }

    public boolean ifSucc() {
        return APICode.SUCCESS.getCode().equals(code);
    }

    public boolean ifNotSucc() {
        return !ifSucc();
    }


    public static <T> BaseResponse<T> success(T data) {
        return BaseResponse.<T>builder().code(APICode.SUCCESS.getCode()).message("操作成功").data(data).build();
    }

    public static <L> BaseResponse<L> success() {
        return BaseResponse.<L>builder().code(APICode.SUCCESS.getCode()).message("操作成功").build();
    }

    public static <L> BaseResponse<L> fail(int code, String errmsg) {
        return BaseResponse.<L>builder().code(code).message(errmsg).build();
    }

    public static <L> BaseResponse<L> fail(int code, String errmsg,L date) {
        return BaseResponse.<L>builder().code(code).message(errmsg).data(date).build();
    }

    public static <L> BaseResponse<L> fail(APICode apiCode) {
        return BaseResponse.<L>builder().code(apiCode.getCode()).message(apiCode.getMessage()).build();
    }

    public static <L> BaseResponse<L> fail(APICode apiCode, String message) {
        return BaseResponse.<L>builder().code(apiCode.getCode()).message(message).build();
    }

    @Override
    public String toString() {
        return "BaseResponse{" +
                "code=" + code +
                ", message='" + message + '\'' +
                ", data=" + data +
                '}';
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

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public static class BaseResponseBuilder<T> {
        private Integer code;
        private String message;
        private T data;

        BaseResponseBuilder() {
        }

        public BaseResponseBuilder<T> code(Integer code) {
            this.code = code;
            return this;
        }

        public BaseResponseBuilder<T> message(String message) {
            this.message = message;
            return this;
        }

        public BaseResponseBuilder<T> data(T data) {
            this.data = data;
            return this;
        }

        public BaseResponse<T> build() {
            return new BaseResponse<T>(code, message, data);
        }

        @Override
        public String toString() {
            return "BaseResponse.BaseResponseBuilder(code=" + this.code + ", message=" + this.message + ", data=" + this.data + ")";
        }
    }
}


