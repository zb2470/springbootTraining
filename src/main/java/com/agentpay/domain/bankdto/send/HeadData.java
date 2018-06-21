package com.agentpay.domain.bankdto.send;

import javax.xml.crypto.Data;

public class HeadData {
    private String serialno;
    private String reqtime;

    public HeadData() {
    }

    public String getSerialno() {
        return serialno;
    }

    public void setSerialno(String serialno) {
        this.serialno = serialno;
    }

    public String getReqtime() {
        return reqtime;
    }

    public void setReqtime(String reqtime) {
        this.reqtime = reqtime;
    }
}
