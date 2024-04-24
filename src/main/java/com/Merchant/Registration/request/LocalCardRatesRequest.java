package com.Merchant.Registration.request;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class LocalCardRatesRequest {

    private String creditLocalHostMDR;
    private String creditLocalMerchantMDR;
    private String creditLocalMobiMDR;
    private String debitLocalHostMDR;
    private String debitLocalMerchantMDR;
    private String debitLocalMobiMDR;
}

