package com.bootcamp.servicepay.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "payment")
@Getter
@Setter
public class Payment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY )
    @Column(unique = true , nullable = false)
    private Long id;
    @Column(name = "service_code")
    private String serviceCode;
    @Column(name = "supply_number")
    private int supplyNumber;
    @Column(name = "pay_amount")
    private float payAmount;
    @Column(name = "transaction_date")
    private Date transactionDate;
}
