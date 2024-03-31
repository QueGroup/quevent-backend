package com.que.quevent.model;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Entity
@Table(name = "users")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @OneToOne
    @JoinColumn(name = "account_id", nullable = false)
    private Account account;

    @Column(name = "created_at")
    private LocalDateTime createdAt;

    @Column(name = "updated_at")
    private LocalDateTime updatedAt;

    @Column(name = "deleted_at")
    private LocalDateTime deletedAt;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    @Column(name = "phone")
    private String phone;

    @Column(name = "username", nullable = false)
    private String username;

    @Column(name = "password", nullable = false)
    private String password;

    @Column(name = "confirmation_code", nullable = false)
    private String confirmationCode;

    @Column(name = "is_registered", nullable = false)
    private Boolean isRegistered;

    @Column(name = "is_confirmed", nullable = false)
    private Boolean isConfirmed;

    @Column(name = "is_parent", nullable = false)
    private Boolean isParent;

    @Column(name = "remember_token")
    private String rememberToken;

    @Column(name = "api_token")
    private String apiToken;

    @Column(name = "email")
    private String email;

    @Column(name = "telegram_id")
    private Long telegramId;

    // Геттеры и сеттеры
}
