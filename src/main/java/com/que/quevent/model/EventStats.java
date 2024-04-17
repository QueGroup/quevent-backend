package com.que.quevent.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
@Table(name="event_stats")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class EventStats {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private LocalDate date;

    private Integer views;

    private Integer uniqueViews;

    private Integer ticketsSold;

    private BigDecimal salesVolume;

    @ManyToOne
    @JoinColumn(name="event_id", nullable = false)
    private Event event;
}
