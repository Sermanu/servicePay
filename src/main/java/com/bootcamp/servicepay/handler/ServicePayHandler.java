package com.bootcamp.servicepay.handler;

import com.bootcamp.servicepay.dto.TransactionRequest;
import com.bootcamp.servicepay.entity.Payment;
import com.bootcamp.servicepay.entity.ServiceInfo;
import com.bootcamp.servicepay.service.ServicePayService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Mono;

@Component
public class ServicePayHandler {

    @Autowired
    private ServicePayService servicePayService;

    public Mono<ServerResponse> savePayment (ServerRequest request) {

        return request.bodyToMono(TransactionRequest.class)
                .flatMap(transactionRequest -> servicePayService.savePay(transactionRequest))
                .flatMap(payment -> ServerResponse.ok()
                        .contentType(MediaType.APPLICATION_JSON)
                        .body(Mono.just(payment), Payment.class))
                .switchIfEmpty(ServerResponse.status(HttpStatus.INTERNAL_SERVER_ERROR).build());
    }

    public Mono<ServerResponse> getServices (ServerRequest request) {
        String channelCode = request.pathVariable("channelCode");

        return servicePayService.getServices(channelCode)
                .flatMap(serviceList -> ServerResponse.ok().body(Mono.just(serviceList), ServiceInfo.class))
                .switchIfEmpty(ServerResponse.noContent().build());

    }
}
