package com.bootcamp.servicepay.service;

import com.bootcamp.servicepay.dto.TransactionRequest;
import com.bootcamp.servicepay.entity.Payment;
import com.bootcamp.servicepay.entity.ServiceInfo;
import reactor.core.publisher.Mono;

import java.util.List;

public interface ServicePayService {

    Mono<Payment> savePay(TransactionRequest request);
    Mono<List<ServiceInfo>> getServices(String channel);
}
