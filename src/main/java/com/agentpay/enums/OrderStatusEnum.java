package com.agentpay.enums;

public enum OrderStatusEnum {
    SUCCESS(0,"成功"),
    PROCESSING(1,"正在处理"),
    FAIL(2,"失败"),
    ABNORMAL(3,"异常"),
    ;
    private Integer code;
    private String message;

    public Integer getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }

    OrderStatusEnum(Integer code, String message) {
        this.code = code;
        this.message = message;
    }
}
