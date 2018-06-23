package com.agentpay.domain.channeldto.send;

import javax.xml.crypto.Data;

public class ChannelHeadSend {

    private String channelNo;
    private String serialno;

    public ChannelHeadSend() {
    }

    public String getChannelNo() {
        return channelNo;
    }

    public void setChannelNo(String channelNo) {
        this.channelNo = channelNo;
    }

    public String getSerialno() {
        return serialno;
    }

    public void setSerialno(String serialno) {
        this.serialno = serialno;
    }

}
