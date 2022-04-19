package com.bootcamp.servicepay.route;

import com.bootcamp.servicepay.handler.ServicePayHandler;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.server.RequestPredicates;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.RouterFunctions;
import org.springframework.web.reactive.function.server.ServerResponse;

@Configuration
public class RouterConfiguration {

    @Bean
    public RouterFunction<ServerResponse> servicePayRoutes (ServicePayHandler servicePayHandler) {
        return RouterFunctions.nest(RequestPredicates.path("/servicePay"),
                RouterFunctions
                        .route(RequestPredicates.GET("/{channelCode}"), servicePayHandler::getServices)
                        .andRoute(RequestPredicates.POST(""), servicePayHandler::savePayment)
                );
    }
}
