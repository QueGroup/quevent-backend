package com.que.quevent.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Table(name = "orders")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @OneToOne
    @JoinColumn(name = "account_id", nullable = false)
    private Account account;

    @ManyToOne
    @JoinColumn(name = "order_status_id", nullable = false)
    private OrderStatus orderStatus;

    @Column(name = "created_at")
    private LocalDateTime createdAt;

    @Column(name = "updated_at")
    private LocalDateTime updatedAt;

    @Column(name = "deleted_at")
    private LocalDateTime deletedAt;

    @Column(name = "order_reference", nullable = false)
    private String orderReference;

    @Column(name = "transaction_id")
    private String transactionId;

    @Column(name = "booking_fee", precision = 8, scale = 2)
    private BigDecimal bookingFee;

    @Column(name = "organiser_booking_fee", precision = 8, scale = 2)
    private BigDecimal organiserBookingFee;

    @Column(name = "order_date")
    private LocalDate orderDate;

    @Column(name = "is_deleted", nullable = false)
    private Boolean isDeleted;

    @Column(name = "is_cancelled", nullable = false)
    private Boolean isCancelled;

    @Column(name = "is_partially_refunded", nullable = false)
    private Boolean isPartiallyRefunded;

    @Column(name = "is_refunded", nullable = false)
    private Boolean isRefunded;

    @Column(name = "amount", precision = 8, scale = 2, nullable = false)
    private BigDecimal amount;

    @Column(name = "amount_refunded", precision = 8, scale = 2)
    private BigDecimal amountRefunded;

    @ManyToOne
    @JoinColumn(name = "event_id", nullable = false)
    private Event event;

    @Column(name = "payment_gateway_id")
    private Integer paymentGatewayId;

    @Column(name = "is_payment_received", nullable = false)
    private Boolean isPaymentReceived;

    @Column(name = "is_business", nullable = false)
    private Boolean isBusiness;

    @Column(name = "taxamt", nullable = false)
    private Double taxAmount;

    @Column(name = "payment_intent")
    private String paymentIntent;

}

