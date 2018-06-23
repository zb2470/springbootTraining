package com.agentpay.service.impl;

import com.agentpay.common.CreateOrderNum;
import com.agentpay.domain.entity.ChannelEntity;
import com.agentpay.domain.entity.OrderEntity;
import com.agentpay.domain.channeldto.result.ChannelResult;
import com.agentpay.domain.channeldto.send.ChannelHeadSend;
import com.agentpay.domain.channeldto.send.ChannelSend;
import com.agentpay.domain.channeldto.send.body.ChannelPaySend;
import com.agentpay.enums.OrderStatusEnum;
import com.agentpay.repository.ChannelEntityRepository;
import com.agentpay.repository.OrderEntityRepository;
import com.agentpay.service.ChannelService;
import com.agentpay.unitl.ChannelResultUnitl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ChannelServiceImpl implements ChannelService {

    @Autowired
    private ChannelEntityRepository channelEntityRepository;

    @Autowired
    private OrderEntityRepository orderEntityRepository;

    /*
    * 渠道代付
    * */
    public ChannelResult pay(ChannelSend channelSend) {
        ChannelHeadSend channelHeadSend=channelSend.headSend;
        ChannelPaySend channelPaySend= (ChannelPaySend) channelSend.getBody();
        List<ChannelEntity> channels=channelEntityRepository.findBychannelNo(channelHeadSend.getChannelNo());
        if(channels==null||channels.size()<=0)
        {
            return ChannelResultUnitl.CreateChannelResult(OrderStatusEnum.FAIL);
        }
        //ChannelEntity channelEntity =channels.get(0);
        List<OrderEntity> orders=orderEntityRepository.findByChannelOrderNo(channelPaySend.getOrderNo());
        if(orders.size()>0)
        {
            return ChannelResultUnitl.CreateChannelResult(OrderStatusEnum.FAIL);
        }

        CreateOrderNum createOrderNum=CreateOrderNum.GetInstance();
        String orderNo=createOrderNum.GetSerialNo();

        OrderEntity orderEntity=new OrderEntity();
        orderEntity.setAccNo(channelPaySend.getAccNo());
        orderEntity.setMoney(channelPaySend.getMoney());
        orderEntity.setName(channelPaySend.getName());
        orderEntity.setChannelOrderNo(channelPaySend.getOrderNo());
        orderEntity.setChannelNo(channelHeadSend.getChannelNo());
        orderEntity.setOrderNo(orderNo);

        orderEntity= orderEntityRepository.save(orderEntity);

        if(orderEntity.getId()<=0)
        {
            return ChannelResultUnitl.CreateChannelResult(OrderStatusEnum.FAIL);
        }

        return ChannelResultUnitl.CreateChannelResult(OrderStatusEnum.SUCCESS);
    }

    public String queryPay() {
        return null;
    }
}
