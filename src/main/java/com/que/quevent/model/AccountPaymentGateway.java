package com.que.quevent.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.util.Date;

@Entity
@Data
@Table(name="account_payment_gateways")
public class AccountPaymentGateway {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @ManyToOne
    @JoinColumn(name="account_id")
    private Account account;

    @ManyToOne
    @JoinColumn(name="payment_gateway_id")
    private PaymentGateway paymentGateway;

    @NotNull
    private String config;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name="deleted_at")
    private Date deletedAt;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name="created_at")
    private Date createdAt;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name="updated_at")
    private Date updatedAt;

}
