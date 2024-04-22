package com.Merchant.Registration.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "MOBIVERSA_MDR")
public class MobiMdr {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(
            name = "MID"
    )
    private String mid;
    @Column(
            name = "RATE_ID"
    )
    private String rateId;
    @Column(
            name = "PROD_ID"
    )
    private String prodId;
    @Column(
            name = "CARD_BRAND"
    )
    private String cardBrand;
    @Column(
            name = "CR_LO_HOST_MDR"
    )
    private float creditLocalHostMDR;
    @Column(
            name = "CR_LO_MRCH_MDR"
    )
    private float creditLocalMerchantMDR;
    @Column(
            name = "CR_LO_MOBI_MDR"
    )
    private float creditLocalMobiMDR;
    @Column(
            name = "CR_FR_HOST_MDR"
    )
    private float creditForeignHostMDR;
    @Column(
            name = "CR_FR_MRCH_MDR"
    )
    private float creditForeignMerchantMDR;
    @Column(
            name = "CR_FR_MOBI_MDR"
    )
    private float creditForeignMobiMDR;
    @Column(
            name = "DR_LO_HOST_MDR"
    )
    private float debitLocalHostMDR;
    @Column(
            name = "DR_LO_MRCH_MDR"
    )
    private float debitLocalMerchantMDR;
    @Column(
            name = "DR_LO_MOBI_MDR"
    )
    private float debitLocalMobiMDR;
    @Column(
            name = "DR_FR_HOST_MDR"
    )
    private float debitForeignHostMDR;
    @Column(
            name = "DR_FR_MRCH_MDR"
    )
    private float debitForeignMerchantMDR;
    @Column(
            name = "DR_FR_MOBI_MDR"
    )
    private float debitForeignMobiMDR;
    private final Date createdDate = new Date();
    private Date modifiedDate;
    private Date suspendDate;
    @Column(
            name = "TIME_STAMP"
    )
    private String timeStamp;
    @Column(
            name = "REMARKS"
    )
    private String remarks;
    @Column(
            name = "SETTLE_PERIOD"
    )
    private String settlePeriod;
    @Column(
            name = "PAYLATER"
    )
    private String payLater;
    @Column(
            name = "AMOUNT"
    )
    private String amount;
    @Column(
            name = "INSTALLMENT"
    )
    private String installment;
    @Column(
            name = "BOOST_QR_HOST_MDR"
    )
    private float boostQrHostMDR;
    @Column(
            name = "BOOST_QR_MRCH_MDR"
    )
    private float boostQrMerchantMDR;
    @Column(
            name = "BOOST_QR_MOBI_MDR"
    )
    private float boostQrMobiMDR;
    @Column(
            name = "BOOST_ECOM_HOST_MDR"
    )
    private float boostEcomHostMDR;
    @Column(
            name = "BOOST_ECOM_MRCH_MDR"
    )
    private float boostEcomMerchantMDR;
    @Column(
            name = "BOOST_ECOM_MOBI_MDR"
    )
    private float boostEcomMobiMDR;
    @Column(
            name = "GRAB_QR_HOST_MDR"
    )
    private float grabQrHostMDR;
    @Column(
            name = "GRAB_QR_MRCH_MDR"
    )
    private float grabQrMerchantMDR;
    @Column(
            name = "GRAB_QR_MOBI_MDR"
    )
    private float grabQrMobiMDR;
    @Column(
            name = "GRAB_ECOM_HOST_MDR"
    )
    private float grabEcomHostMDR;
    @Column(
            name = "GRAB_ECOM_MRCH_MDR"
    )
    private float grabEcomMerchantMDR;
    @Column(
            name = "GRAB_ECOM_MOBI_MDR"
    )
    private float grabEcomMobiMDR;
    @Column(
            name = "SPLIT_ENABLE"
    )
    private String splitEnable;
    @Column(
            name = "FPX_TXN_MDR"
    )
    private float fpxTxnMdr;
    @Column(
            name = "FPX_MOBI_AMOUNT"
    )
    private float fpxMobiAmt;
    @Column(
            name = "FPX_HOST_AMOUNT"
    )
    private float fpxHostAmt;
    @Column(
            name = "FPX_MERC_AMOUNT"
    )
    private float fpxMercAmt;
    @Column(
            name = "TIER"
    )
    private String tier;
    @Column(
            name = "PREAUTH_MDR"
    )
    private String preAuthMDR;
    @Column(
            name = "TNG_QR_HOST_MDR"
    )
    private float tngQrHostMDR;
    @Column(
            name = "TNG_QR_MRCH_MDR"
    )
    private float tngQrMerchantMDR;
    @Column(
            name = "TNG_QR_MOBI_MDR"
    )
    private float tngQrMobiMDR;
    @Column(
            name = "TNG_ECOM_HOST_MDR"
    )
    private float tngEcomHostMDR;
    @Column(
            name = "TNG_ECOM_MRCH_MDR"
    )
    private float tngEcomMerchantMDR;
    @Column(
            name = "TNG_ECOM_MOBI_MDR"
    )
    private float tngEcomMobiMDR;
    @Column(
            name = "BNPL_QR_HOST_MDR"
    )
    private float bnplQrHostMDR;
    @Column(
            name = "BNPL_QR_MRCH_MDR"
    )
    private float bnplQrMerchantMDR;
    @Column(
            name = "BNPL_QR_MOBI_MDR"
    )
    private float bnplQrMobiMDR;
    @Column(
            name = "BNPL_ECOM_HOST_MDR"
    )
    private float bnplEcomHostMDR;
    @Column(
            name = "BNPL_ECOM_MRCH_MDR"
    )
    private float bnplEcomMerchantMDR;
    @Column(
            name = "BNPL_ECOM_MOBI_MDR"
    )
    private float bnplEcomMobiMDR;


}
