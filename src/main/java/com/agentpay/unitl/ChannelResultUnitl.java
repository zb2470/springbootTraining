package com.agentpay.unitl;

import com.agentpay.domain.Status;
import com.agentpay.domain.channeldto.result.ChannelResult;
import com.agentpay.enums.OrderStatusEnum;

public class ChannelResultUnitl {

    public static ChannelResult CreateChannelResult(OrderStatusEnum orderStatusEnum, Object object) {
        Status status = new Status();
        status.setStatusCode(orderStatusEnum.getCode());
        status.setStatusMassage(orderStatusEnum.getMessage());

        ChannelResult channelResult = new ChannelResult();
        channelResult.setStatus(status);
        channelResult.setBody(object);

        return channelResult;
    }

    public static ChannelResult CreateChannelResult(OrderStatusEnum orderStatusEnum) {
        return CreateChannelResult(orderStatusEnum);
    }
}
