package com.agentpay.repository;

import com.agentpay.domain.entity.OrderEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface OrderEntityRepository extends JpaRepository<OrderEntity, Integer> {
    public List<OrderEntity> findByChannelOrderNo(String ChannelOrderNo);
}
