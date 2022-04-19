package com.bootcamp.servicepay.service.impl;

import com.bootcamp.servicepay.dto.TransactionRequest;
import com.bootcamp.servicepay.entity.Payment;
import com.bootcamp.servicepay.entity.ServiceInfo;
import com.bootcamp.servicepay.repository.PaymentRepository;
import com.bootcamp.servicepay.repository.ServiceInfoRepository;
import com.bootcamp.servicepay.service.ServicePayService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.Date;
import java.util.List;

@Service
public class ServicePayServiceImpl implements ServicePayService {

    @Autowired
    private PaymentRepository paymentRepository;

    @Autowired
    private ServiceInfoRepository serviceInfoRepository;

    @Override
    public Mono<Payment> savePay(TransactionRequest request) {
        try {
            Payment entity = new Payment();
            entity.setServiceCode(request.getServiceCode());
            entity.setSupplyNumber(request.getSupplyNumber());
            entity.setPayAmount(request.getPayAmount());

            ZonedDateTime zonedDateTime = ZonedDateTime.now(ZoneId.of("America/Lima"));
            Date dateToSaved = Date.from(zonedDateTime.toInstant());
            entity.setTransactionDate(dateToSaved);

            Payment entitySaved = paymentRepository.save(entity);

            return Mono.just(entitySaved);
        } catch (Exception e) {
            return Mono.empty();
        }


    }

    @Override
    public Mono<List<ServiceInfo>>  getServices(String channel) {
        List<ServiceInfo> serviceInfoList = serviceInfoRepository.findByChannelType(channel);

        if (serviceInfoList.isEmpty()) {
            return Mono.empty();
        } else {
            return Mono.just(serviceInfoList);
        }
    }
}
