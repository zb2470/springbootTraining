package com.agentpay.domain.bankdto.result;

import com.agentpay.domain.Status;

public class Result<T> {
    private HeadData headData;

    private T bodyData;

    private Status status;

    private String autograph;

    public String getAutograph() {
        return autograph;
    }

    public void setAutograph(String autograph) {
        this.autograph = autograph;
    }

    public Result(HeadData headData) {
        this.headData = headData;
    }

    public HeadData getHeadData() {
        return headData;
    }

    public void setHeadData(HeadData headData) {
        this.headData = headData;
    }

    public T getBodyData() {
        return bodyData;
    }

    public void setBodyData(T bodyData) {
        this.bodyData = bodyData;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }
}
