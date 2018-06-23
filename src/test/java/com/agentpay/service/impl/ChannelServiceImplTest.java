package com.agentpay.service.impl;

import com.agentpay.common.CreateOrderNum;
import com.agentpay.domain.Status;
import com.agentpay.domain.channeldto.result.ChannelResult;
import com.agentpay.domain.channeldto.send.ChannelHeadSend;
import com.agentpay.domain.channeldto.send.ChannelSend;
import com.agentpay.domain.channeldto.send.body.ChannelPaySend;
import com.agentpay.service.ChannelService;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ChannelServiceImplTest {

    @Autowired
    private ChannelService channelService;

    @Test
    public void pay() {
        ChannelSend channelSend = new ChannelSend();

        ChannelHeadSend channelHeadSend = new ChannelHeadSend();
        channelHeadSend.setChannelNo("123");
        channelHeadSend.setSerialno("1234568");

        ChannelPaySend channelPaySend = new ChannelPaySend();
        channelPaySend.setAccNo("1234567");
        channelPaySend.setMoney("100");

        CreateOrderNum createOrderNum=CreateOrderNum.GetInstance();

        channelPaySend.setOrderNo(createOrderNum.GetSerialNo());
        channelPaySend.setName("小王八");

        channelSend.headSend = channelHeadSend;
        channelSend.setBody(channelPaySend);

        ChannelResult channelResult = channelService.pay(channelSend);
        Status status = channelResult.status;

        Assert.assertEquals(new Integer(0), status.getStatusCode());
    }

    @Test
    public void queryPay() {
    }
}