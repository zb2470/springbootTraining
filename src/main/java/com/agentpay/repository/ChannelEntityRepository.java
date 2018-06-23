package com.agentpay.repository;

import com.agentpay.domain.entity.ChannelEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ChannelEntityRepository extends JpaRepository<ChannelEntity, Integer> {

    public List<ChannelEntity> findBychannelNo(String channelNo);

}
