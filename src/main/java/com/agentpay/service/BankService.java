package com.agentpay.service;

import com.agentpay.common.EncryptHelper;
import com.agentpay.common.JsonHelper;
import com.agentpay.common.dateHelper;
import com.agentpay.common.httpClientHelper;
import com.agentpay.domain.OrderEntity;
import com.agentpay.domain.bankdto.result.Result;
import com.agentpay.domain.Status;
import com.agentpay.domain.bankdto.send.HeadData;
import com.agentpay.domain.bankdto.send.Send;
import com.agentpay.domain.bankdto.send.bodydata.Pay;
import com.agentpay.repository.ChannelEntityRepository;
import com.agentpay.repository.OrderEntityRepository;
import com.fasterxml.jackson.core.JsonProcessingException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public interface BankService {

    public String sendOrderToBank(Integer id) throws JsonProcessingException ;

    public String sendQueryToBank(Integer id);

}
