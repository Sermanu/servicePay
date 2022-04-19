package com.bootcamp.servicepay.repository;

import com.bootcamp.servicepay.entity.ServiceInfo;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ServiceInfoRepository extends JpaRepository<ServiceInfo, Long> {
    List<ServiceInfo> findByChannelType(String channelType);
}
