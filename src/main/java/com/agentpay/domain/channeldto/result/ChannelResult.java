package com.agentpay.domain.channeldto.result;

import com.agentpay.domain.Status;

public class ChannelResult {
    public Status status;
    public Object body;

    public ChannelResult() {
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public Object getBody() {
        return body;
    }

    public void setBody(Object body) {
        this.body = body;
    }
}
