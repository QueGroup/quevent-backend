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
public class Event {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private long id;

    @NotNull
    private String title;

    private String location;

    @NotNull
    private String type;

    @Column(name="image_path")
    private String imagePath;

    @NotNull
    private String description;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name="start_date")
    private Date startDate;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name="end_date")
    private Date endDate;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name="on_sale_date")
    private Date onSaleDate;

    @Column(name="account_id")
    @NotNull
    private long accountId;

    @ManyToOne
    @JoinColumn(name="user_id", nullable = false)
    private User user;

    @NotNull
    @Column(name="sales_volume")
    private BigDecimal salesVolume;

    @Column(name="venue_name")
    @NotNull
    private String venueName;

    @Column(name="venue_name_full")
    private String venueNameFull;

    private String address;

    @Column(name="street_number")
    private String streetNumber;

    private BigDecimal latitude;

    private BigDecimal longitude;

    @Column(name="google_place_id")
    private String googlePlaceId;

    @Column(name="pre_order_display_message")
    private String preOrderDisplayMessage;

    @Column(name="post_order_display_message")
    private String postOrderDisplayMessage;

    @Column(name="location_is_manual")
    private int locationIsManual;

    @Column(name="is_live")
    @NotNull
    private boolean isLive;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name="created_at")
    private Date createdAt;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name="updated_at")
    private Date updatedAt;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name="deleted_at")
    private Date deletedAt;

    @NotNull
    @Column(name="barcode_type")
    private String barcodeType;

    @NotNull
    @Column(name="ticket_border_color")
    private String ticketBorderColor;

    @NotNull
    @Column(name="ticket_bg_color")
    private String ticketBgColor;

    @NotNull
    @Column(name="ticket_text_color")
    private String ticketTextColor;

    @NotNull
    @Column(name="ticket_sub_text_color")
    private String ticketSubTextColor;

    @Column(name="google_tag_manager_code")
    private String googleTagManagerCode;

    @Column(name="social_show_whatsapp")
    @NotNull
    private boolean socialShowWhatsapp;

    @NotNull
    @Column(name="checkout_timeout_after")
    private int checkoutTimeoutAfter;

    @NotNull
    @Column(name="is_1d_barcode_enabled ")
    private int is1dBarcodeEnabled;

    @Column(name="start_age_limit", nullable = false)
    private int startAgeLimit;

    @Column(name="end", nullable = false)
    private int endAgeLimit;

}
