package com.bootcamp.servicepay.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class TransactionRequest {

    private String serviceCode;
    private int supplyNumber;
    private float payAmount;
}
