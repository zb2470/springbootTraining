package com.agentpay.domain.channeldto.send;

import com.agentpay.domain.channeldto.send.body.ChannelPaySend;

public class ChannelSend {

    public ChannelHeadSend headSend;
    public Object body;
    public String autograph;

    public ChannelSend() {
    }

    public ChannelHeadSend getHeadSend() {
        return headSend;
    }

    public void setHeadSend(ChannelHeadSend headSend) {
        this.headSend = headSend;
    }

    public Object getBody() {
        return body;
    }

    public void setBody(Object body) {
        this.body = body;
    }

    public String getAutograph() {
        return autograph;
    }

    public void setAutograph(String autograph) {
        this.autograph = autograph;
    }
}
