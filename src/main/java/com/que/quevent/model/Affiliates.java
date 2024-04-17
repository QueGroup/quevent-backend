package com.que.quevent.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.math.BigDecimal;
import java.util.Date;

@Entity
@Data
public class Affiliates {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @NotNull
    private String name;

    @NotNull
    private int visits;

    @NotNull
    @Column(name="tickets_sold")
    private int ticketsSold;

    @NotNull
    @Column(name="sales_volume")
    private BigDecimal salesVolume;

    @NotNull
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name="last_visit")
    private Date lastVisit;

    @ManyToOne
    @JoinColumn(name="account_id", nullable = false)
    private Account account;

    @ManyToOne
    @JoinColumn(name="event_id", nullable = false)
    private Event event;
    
    @Column(name="created_at")
    @Temporal(TemporalType.TIMESTAMP)
    private Date createdAt;
    
    @Column(name="updated_at")
    @Temporal(TemporalType.TIMESTAMP)
    private Date updatedAt;
}
