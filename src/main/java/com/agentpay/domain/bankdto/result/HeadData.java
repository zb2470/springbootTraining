package com.agentpay.domain.bankdto.result;

import javax.xml.crypto.Data;

public class HeadData {
    private String serialno;
    private Data reqtime;

    public HeadData() {
    }

    public String getSerialno() {
        return serialno;
    }

    public void setSerialno(String serialno) {
        this.serialno = serialno;
    }

    public Data getReqtime() {
        return reqtime;
    }

    public void setReqtime(Data reqtime) {
        this.reqtime = reqtime;
    }
}
