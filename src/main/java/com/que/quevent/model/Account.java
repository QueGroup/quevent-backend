package com.que.quevent.model;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Date;

@Entity
@Table(name = "accounts")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Account {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "first_name", nullable = false)
    private String firstName;

    @Column(name = "last_name", nullable = false)
    private String lastName;

    @Column(nullable = false)
    private String email;

    @Column(name = "created_at")
    private LocalDateTime createdAt;

    @Column(name = "updated_at")
    private LocalDateTime updatedAt;

    @Column(name = "deleted_at")
    private LocalDateTime deletedAt;

    private String name;

    @Column(name = "last_ip")
    private String lastIp;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "last_login_date")
    private Date lastLoginDate;

    @Column(nullable = false)
    private String city;

    @Column(name = "country_id", nullable = false)
    private Integer countryId;

    @Column(name = "email_footer")
    private String emailFooter;

    @Column(name = "is_active", nullable = false)
    private Boolean isActive;

    @Column(name = "is_banned", nullable = false)
    private Boolean isBanned;

    @Column(name = "is_beta", nullable = false)
    private Boolean isBeta;

    @Column(name = "stripe_access_token")
    private String stripeAccessToken;

    @Column(name = "stripe_refresh_token")
    private String stripeRefreshToken;

    @Column(name = "stripe_secret_key")
    private String stripeSecretKey;

    @Column(name = "stripe_publishable_key")
    private String stripePublishableKey;

    @Column(name = "stripe_data_raw")
    private String stripeDataRaw;

    @Column(name = "payment_gateway_id", nullable = false)
    private Integer paymentGatewayId;

    @Column(nullable = false)
    private BigDecimal longitude;

    @Column(nullable = false)
    private BigDecimal latitude;

}

