package com.agentpay.service.impl;

import com.agentpay.repository.ChannelEntityRepository;
import com.agentpay.repository.OrderEntityRepository;
import com.agentpay.service.ChannelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ChannelServiceImpl implements ChannelService {

    @Autowired
    private ChannelEntityRepository channelEntityRepository;

    @Autowired
    private OrderEntityRepository orderEntityRepository;

    public String pay() {
        return null;
    }

    public String queryPay() {
        return null;
    }
}
