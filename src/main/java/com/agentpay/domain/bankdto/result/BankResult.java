package com.agentpay.domain.bankdto.result;

import com.agentpay.domain.Status;

public class BankResult<T> {
    private BankHeadResult headData;

    private T bodyData;

    private Status status;

    private String autograph;

    public String getAutograph() {
        return autograph;
    }

    public void setAutograph(String autograph) {
        this.autograph = autograph;
    }

    public BankResult(BankHeadResult headData) {
        this.headData = headData;
    }

    public BankHeadResult getHeadData() {
        return headData;
    }

    public void setHeadData(BankHeadResult headData) {
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
