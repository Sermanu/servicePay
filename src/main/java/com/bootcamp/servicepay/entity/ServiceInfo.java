package com.bootcamp.servicepay.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "service_info")
@Getter
@Setter
public class ServiceInfo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY )
    @Column(unique = true , nullable = false)
    private Long id;
    @Column(name = "channel_type")
    private String channelType;
    @Column(name = "service_code")
    private String serviceCode;
}
