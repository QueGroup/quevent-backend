package com.que.quevent.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.util.Date;

@Entity
@Data
@Table(name="event_images")
public class EventImage {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @NotNull
    @Column(name="remote_url")
    private String remoteUrl;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name="created_at")
    private Date createdAt;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name="updated_at")
    private Date updatedAt;


    @ManyToOne
    @JoinColumn(name="account_id", nullable = false)
    private Event event;


}
