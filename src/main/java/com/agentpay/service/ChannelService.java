package com.agentpay.service;

import com.agentpay.domain.channeldto.result.ChannelResult;
import com.agentpay.domain.channeldto.send.ChannelSend;
import org.springframework.stereotype.Service;

@Service
public interface ChannelService {

    public ChannelResult pay(ChannelSend channelSend);

    public String queryPay();
}
