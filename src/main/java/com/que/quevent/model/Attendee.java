package com.que.quevent.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(name="attendies")
public class Attendee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @ManyToOne
    @JoinColumn(name="order_id")
    private Order order;

    @Column(name = "ticket_id", nullable = false)
    private int ticketId;

    @ManyToOne
    @JoinColumn(name="event_id", nullable = false)
    private Event event;

    @Column(name = "private_reference_number", nullable = false)
    private String privateReferenceNumber;

    @Column(name = "created_at")
    private LocalDateTime createdAt;

    @Column(name = "updated_at")
    private LocalDateTime updatedAt;

    @Column(name = "deleted_at")
    private LocalDateTime deletedAt;

    @Column(name = "is_cancelled", nullable = false)
    private Boolean isCancelled;

    @Column(name = "has_arrived", nullable = false)
    private Boolean hasArrived;

    @Column(name = "arrival_time")
    private LocalDateTime arrivalTime;


    @ManyToOne()
    @JoinColumn(name="account_id", nullable = false)
    private Account account;

    @Column(name = "reference_index", nullable = false)
    private Integer referenceIndex;

    @Column(name = "is_refunded", nullable = false)
    private Boolean isRefunded;

}
