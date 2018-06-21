package com.agentpay.service;

import org.springframework.stereotype.Service;

@Service
public interface ChannelService {

    public String pay();

    public String queryPay();
}
