package com.Merchant.Registration.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.*;

@Entity
@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "MDR_RATES")
public class MdrRates {
    @Id
    @Column(name = "ID")
    private Long id;
    @Column(
            name = "PRODUCT_ID"
    )
    private String productId;
    @Column(
            name = "RATE_ID"
    )
    private String rateId;
    @Column(
            name = "VALID_FROM"
    )
    private String validFrom;
    @Column(
            name = "VALID_TO"
    )
    private String validTo;
    @Column(
            name = "MID_MAPPED"
    )
    private String midMapped;
    @Column(
            name = "BOOST_MDR"
    )
    private float boostMdr;
    @Column(
            name = "GRABPAY_MDR"
    )
    private float grabpayMdr;
    @Column(
            name = "HOST_TYPE"
    )
    private String hostType;
    @Column(
            name = "LO_DR_VISA_MERCH"
    )
    private float debitLocalVisaMerch;
    @Column(
            name = "LO_CR_VISA_MERCH"
    )
    private float creditLocalVisaMerch;
    @Column(
            name = "FO_DR_VISA_MERCH"
    )
    private float debitForeignVisaMerch;
    @Column(
            name = "FO_CR_VISA_MERCH"
    )
    private float creditForeignVisaMerch;
    @Column(
            name = "LO_DR_MC_MERCH"
    )
    private float debitLocalMcMerch;
    @Column(
            name = "LO_CR_MC_MERCH"
    )
    private float creditLocalMcMerch;
    @Column(
            name = "FO_DR_MC_MERCH"
    )
    private float debitForeignMcMerch;
    @Column(
            name = "FO_CR_MC_MERCH"
    )
    private float creditForeignMcMerch;
    @Column(
            name = "LO_DR_UP_MERCH"
    )
    private float debitLocalUpMerch;
    @Column(
            name = "LO_CR_UP_MERCH"
    )
    private float creditLocalUpMerch;
    @Column(
            name = "FO_DR_UP_MERCH"
    )
    private float debitForeignUpMerch;
    @Column(
            name = "FO_CR_UP_MERCH"
    )
    private float creditForeignUpMerch;
    @Column(
            name = "LO_DR_VISA_HOST"
    )
    private float debitLocalVisaHost;
    @Column(
            name = "LO_CR_VISA_HOST"
    )
    private float creditLocalVisaHost;
    @Column(
            name = "FO_DR_VISA_HOST"
    )
    private float debitForeignVisaHost;
    @Column(
            name = "FO_CR_VISA_HOST"
    )
    private float creditForeignVisaHost;
    @Column(
            name = "LO_DR_MC_HOST"
    )
    private float debitLocalMcHost;
    @Column(
            name = "LO_CR_MC_HOST"
    )
    private float creditLocalMcHost;
    @Column(
            name = "FO_DR_MC_HOST"
    )
    private float debitForeignMcHost;
    @Column(
            name = "FO_CR_MC_HOST"
    )
    private float creditForeignMcHost;
    @Column(
            name = "LO_DR_UP_HOST"
    )
    private float debitLocalUpHost;
    @Column(
            name = "LO_CR_UP_HOST"
    )
    private float creditLocalUpHost;
    @Column(
            name = "FO_DR_UP_HOST"
    )
    private float debitForeignUpHost;
    @Column(
            name = "FO_CR_UP_HOST"
    )
    private float creditForeignUpHost;
    @Column(
            name = "LO_DR_VISA_MOBI"
    )
    private float debitLocalVisaMobi;
    @Column(
            name = "LO_CR_VISA_MOBI"
    )
    private float creditLocalVisaMobi;
    @Column(
            name = "FO_DR_VISA_MOBI"
    )
    private float debitForeignVisaMobi;
    @Column(
            name = "FO_CR_VISA_MOBI"
    )
    private float creditForeignVisaMobi;
    @Column(
            name = "LO_DR_MC_MOBI"
    )
    private float debitLocalMcMobi;
    @Column(
            name = "LO_CR_MC_MOBI"
    )
    private float creditLocalMcMobi;
    @Column(
            name = "FO_DR_MC_MOBI"
    )
    private float debitForeignMcMobi;
    @Column(
            name = "FO_CR_MC_MOBI"
    )
    private float creditForeignMcMobi;
    @Column(
            name = "LO_DR_UP_MOBI"
    )
    private float debitLocalUpMobi;
    @Column(
            name = "LO_CR_UP_MOBI"
    )
    private float creditLocalUpMobi;
    @Column(
            name = "FO_DR_UP_MOBI"
    )
    private float debitForeignUpMobi;
    @Column(
            name = "FO_CR_UP_MOBI"
    )
    private float creditForeignUpMobi;
    @Column(
            name = "TIME_STAMP"
    )
    private String timeStamp;
    @Column(
            name = "IP_ADDRESS"
    )
    private String ipAddress;
    @Column(
            name = "USER_REFERENCE"
    )
    private String userRefference;

}
