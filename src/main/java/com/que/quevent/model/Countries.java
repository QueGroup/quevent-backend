package com.que.quevent.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Entity
@Data
public class Countries {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String capital;

    private String citizenship;

    @NotNull
    @Column(name="country_code")
    private String countryCode;

    private String currency;

    @Column(name="currency_code")
    private String currencyCode;

    @Column(name="currency_sub_unit")
    private String currencySubUnit;

    @Column(name="full_name")
    private String fullName;

    @NotNull
    @Column(name="iso_3166_2")
    private String iso31662;

    @NotNull
    @Column(name="iso_3166_3")
    private String iso31663;

    @NotNull
    private String name;

    @NotNull
    @Column(name="region_code")
    private String regionCode;

    @NotNull
    @Column(name="sub_region_code")
    private String subRegionCode;

    @NotNull
    private boolean eea;
}
