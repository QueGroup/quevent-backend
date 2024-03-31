package com.que.quevent.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.Date;

@Entity
@Data
@Table(name="password_resets")
public class PasswordResets {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne
    @JoinColumn(name="email")
    private User user;

    private String token;

    private LocalDateTime createdAt;

    private Integer telegramId;



}
