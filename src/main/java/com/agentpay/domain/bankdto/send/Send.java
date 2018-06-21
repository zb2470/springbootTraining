package com.agentpay.domain.bankdto.send;

public class Send<T> {

    private HeadData headData;
    private T t;
    private String autograph;

    public Send() {
    }

    public HeadData getHeadData() {
        return headData;
    }

    public void setHeadData(HeadData headData) {
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
