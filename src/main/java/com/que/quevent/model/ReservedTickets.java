package com.que.quevent.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.util.Date;

@Entity
@Data
@Table(name = "reserved_tickets")
public class ReservedTickets {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @NotNull
    @Column(name="ticket_id")
    private long ticketId;

    @ManyToOne
    @JoinColumn (name="event_id", nullable = false)
    private Event event;

    @NotNull
    @Column(name="quantity_reserved")
    private int quantityReserved;

    @NotNull
    @Temporal(TemporalType.TIMESTAMP)
    private Date expires;

    @NotNull
    @Column(name="session_id")
    private String sessionId;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name="created_at")
    private Date createdAt;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name="updated_at")
    private Date updatedAt;



}
