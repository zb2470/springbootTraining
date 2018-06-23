package com.agentpay.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import org.springframework.stereotype.Service;

@Service
public interface BankService {

    public String sendOrderToBank(Integer id) throws JsonProcessingException ;

    public String sendQueryToBank(Integer id);

}
