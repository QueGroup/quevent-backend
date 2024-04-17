package com.que.quevent.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Entity
@Data
@Table(name = "payment_gateways")
public class PaymentGateway {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @NotNull
    @Column(name="provider_name")
    private String providerName;

    @NotNull
    @Column(name="provider_url")
    private String providerUrl;

    @NotNull
    @Column(name="is_on_site")
    private boolean isOnSite;

    @NotNull
    @Column(name="can_refund")
    private boolean canRefund;

    @NotNull
    private String name;

    @NotNull
    private boolean def;

    @NotNull
    @Column(name="admin_blade_template")
    private String adminBladeTemplate;

    @NotNull
    @Column(name="checkout_blade_template")
    private String checkoutBladeTemplate;


}
