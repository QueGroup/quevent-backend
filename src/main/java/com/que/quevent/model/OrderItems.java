package com.que.quevent.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.math.BigDecimal;
import java.util.Date;

@Entity
@Data
@Table(name="order_items")
public class OrderItems {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @NotNull
    private String title;

    @NotNull
    private int quantity;

    @NotNull
    @Column(name="unit_price")
    private BigDecimal unitPrice;

    @Column(name="unit_booking_fee")
    private BigDecimal unitBookingFee;

    @ManyToOne
    @JoinColumn (name="order_id", nullable = false)
    private Order order;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name="deleted_at")
    private Date deletedAt;


}
