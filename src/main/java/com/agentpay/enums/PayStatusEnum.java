package com.agentpay.enums;

public enum PayStatusEnum {
    WAIT(0,"等待处理"),
    SUCCESS(1,"正在处理"),
    PROCESSING(2,"成功"),
    FAIL(3,"失败"),
    ABNORMAL(4,"异常"),
    ;

    private Integer code;
    private String message;

    PayStatusEnum(Integer code, String message) {
        this.code = code;
        this.message = message;
    }

    public Integer getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }
}
