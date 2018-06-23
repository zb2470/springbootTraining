package com.agentpay.controller;

import com.agentpay.domain.channeldto.result.ChannelResult;
import com.agentpay.domain.channeldto.send.ChannelSend;
import com.agentpay.enums.OrderStatusEnum;
import com.agentpay.service.ChannelService;
import com.agentpay.unitl.ChannelResultUnitl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("/channel")
public class ChannelController {

    @Autowired
    private ChannelService channelService;

    @PostMapping("/post")
    public ChannelResult pay(@Valid ChannelSend channelSend, BindingResult bindingResult){
        if(bindingResult.hasErrors())
        {
            return ChannelResultUnitl.CreateChannelResult(OrderStatusEnum.FAIL);
        }
        return channelService.pay(channelSend);
    }

    public String queryPay(){
        return null;
    }
}
