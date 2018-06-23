package com.agentpay.service.impl;

import com.agentpay.common.EncryptHelper;
import com.agentpay.common.JsonHelper;
import com.agentpay.common.dateHelper;
import com.agentpay.common.HttpUtil;
import com.agentpay.domain.entity.ChannelEntity;
import com.agentpay.domain.entity.OrderEntity;
import com.agentpay.domain.Status;
import com.agentpay.domain.bankdto.result.BankResult;
import com.agentpay.domain.bankdto.send.BankHeadSend;
import com.agentpay.domain.bankdto.send.BankSend;
import com.agentpay.domain.bankdto.send.bodydata.BankPaySend;
import com.agentpay.repository.ChannelEntityRepository;
import com.agentpay.repository.OrderEntityRepository;
import com.agentpay.service.BankService;
import com.fasterxml.jackson.core.JsonProcessingException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.*;

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

        List<ChannelEntity> channels=channelEntityRepository.findBychannelNo(orderEntity.getChannelNo());
        if(channels==null||channels.size()<=0)
        {
            return "";
        }
        ChannelEntity channelEntity=channels.get(0);

        BankPaySend pay=new BankPaySend();
        pay.setName(orderEntity.getName());
        pay.setAccNo(orderEntity.getAccNo());
        pay.setMoney(orderEntity.getMoney());
        pay.setOrderNo(orderEntity.getOrderNo());

        BankHeadSend headData=new BankHeadSend();
        headData.setSerialno("123");
        headData.setReqtime(dateHelper.getNowTime());

        BankSend<BankPaySend> send=new BankSend<BankPaySend>();

        String headJson=JsonHelper.objToJson(headData);
        String bodyJson=JsonHelper.objToJson(pay);

        String autograph=EncryptHelper.aesEncrypt(headJson+bodyJson,channelEntity.getAesKey(),channelEntity.getAesIv());

        send.setT(pay);
        send.setHeadData(headData);
        send.setAutograph(autograph);

        String sendJson=JsonHelper.objToJson(send);

        Map<String,String> map=new HashMap<String, String>();
        map.put("par",sendJson);

        String resultJson= HttpUtil.doPost(bankUrl,map);

        BankResult result= (BankResult) JsonHelper.jsonToObj(resultJson);

        //验签
        BigDecimal money=new BigDecimal(orderEntity.getMoney());
        BigDecimal banlance=channelEntity.getBalance();
        money=banlance.subtract(money);
        channelEntity.setBalance(money);

        Status status=result.getStatus();
        orderEntity.setStatusCode(status.getStatusCode());
        orderEntity.setStatusMessage(status.getStatusMassage());
        //默认都是成功



        //修改状态
        orderEntityRepository.save(orderEntity);
        channelEntityRepository.save(channelEntity);

        return "success";
    }

    public String sendQueryToBank(Integer id){
        return null;
    }


}
