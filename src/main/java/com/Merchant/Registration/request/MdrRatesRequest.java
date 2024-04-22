package com.Merchant.Registration.request;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class MdrRatesRequest {
    private Long id;
    private String productId;
    private String rateId;
    private String validFrom;
    private String validTo;
    private String midMapped;
    private float boostMdr;
    private float grabpayMdr;
    private String hostType;
    private float debitLocalVisaMerch;
    private float creditLocalVisaMerch;
    private float debitForeignVisaMerch;
    private float creditForeignVisaMerch;
    private float debitLocalMcMerch;
    private float creditLocalMcMerch;
    private float debitForeignMcMerch;
    private float creditForeignMcMerch;
    private float debitLocalUpMerch;
    private float creditLocalUpMerch;
    private float debitForeignUpMerch;
    private float creditForeignUpMerch;
    private float debitLocalVisaHost;
    private float creditLocalVisaHost;
    private float debitForeignVisaHost;
    private float creditForeignVisaHost;
    private float debitLocalMcHost;
    private float creditLocalMcHost;
    private float debitForeignMcHost;
    private float creditForeignMcHost;
    private float debitLocalUpHost;
    private float creditLocalUpHost;
    private float debitForeignUpHost;
    private float creditForeignUpHost;
    private float debitLocalVisaMobi;
    private float creditLocalVisaMobi;
    private float debitForeignVisaMobi;
    private float creditForeignVisaMobi;
    private float debitLocalMcMobi;
    private float creditLocalMcMobi;
    private float debitForeignMcMobi;
    private float creditForeignMcMobi;
    private float debitLocalUpMobi;
    private float creditLocalUpMobi;
    private float debitForeignUpMobi;
    private float creditForeignUpMobi;
    private String timeStamp;
    private String ipAddress;
    private String userRefference;
}
