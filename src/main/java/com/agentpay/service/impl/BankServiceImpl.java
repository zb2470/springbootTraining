package com.agentpay.service.impl;

import com.agentpay.common.EncryptHelper;
import com.agentpay.common.JsonHelper;
import com.agentpay.common.dateHelper;
import com.agentpay.common.httpClientHelper;
import com.agentpay.domain.OrderEntity;
import com.agentpay.domain.Status;
import com.agentpay.domain.bankdto.result.Result;
import com.agentpay.domain.bankdto.send.HeadData;
import com.agentpay.domain.bankdto.send.Send;
import com.agentpay.domain.bankdto.send.bodydata.Pay;
import com.agentpay.repository.ChannelEntityRepository;
import com.agentpay.repository.OrderEntityRepository;
import com.agentpay.service.BankService;
import com.fasterxml.jackson.core.JsonProcessingException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class BankServiceImpl implements  BankService {
    @Value("${bankUrl}")
    private String bankUrl;

    @Autowired
    private ChannelEntityRepository channelEntityRepository;

    @Autowired
    private OrderEntityRepository orderEntityRepository;

    public String sendOrderToBank(Integer id) throws JsonProcessingException {
        OrderEntity orderEntity =orderEntityRepository.findById(id).get();
        if(orderEntity==null){
            return "";
        }

        Pay pay=new Pay();

        pay.setName(orderEntity.getName());
        pay.setAccNo(orderEntity.getAccNo());
        pay.setMoney(orderEntity.getMoney());
        pay.setOrderNo(orderEntity.getOrderNo());

        Send<Pay> send=new Send<Pay>();
        send.setT(pay);

        HeadData headData=new HeadData();
        headData.setSerialno("123");
        headData.setReqtime(dateHelper.getNowTime());
        send.setHeadData(headData);

        String headJson=JsonHelper.objToJson(send.getHeadData());
        String bodyJson=JsonHelper.objToJson(send.getT());

        String autograph=EncryptHelper.aesEncrypt(headJson+bodyJson,"","");
        send.setAutograph(autograph);

        String sendJson=JsonHelper.objToJson(send);

        String resultJson= httpClientHelper.post(bankUrl,sendJson);

        Result result= (Result) JsonHelper.jsonToObj(resultJson);

        //验签
        Status status=result.getStatus();
        orderEntity.setStatusCode(status.getStatusCode());
        orderEntity.setStatusMessage(status.getStatusMassage());

        //修改状态
        orderEntityRepository.save(orderEntity);

        return "success";
    }

    public String sendQueryToBank(Integer id){
        return null;
    }


}
