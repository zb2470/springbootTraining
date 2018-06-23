package com.agentpay.domain.bankdto.send;

public class BankSend<T> {

    private BankHeadSend headData;
    private T t;
    private String autograph;

    public BankSend() {
    }

    public BankHeadSend getHeadData() {
        return headData;
    }

    public void setHeadData(BankHeadSend headData) {
        this.headData = headData;
    }

    public T getT() {
        return t;
    }

    public void setT(T t) {
        this.t = t;
    }

    public String getAutograph() {
        return autograph;
    }

    public void setAutograph(String autograph) {
        this.autograph = autograph;
    }
}
