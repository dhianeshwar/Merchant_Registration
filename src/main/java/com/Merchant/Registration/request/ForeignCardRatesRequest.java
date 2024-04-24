package com.Merchant.Registration.request;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class ForeignCardRatesRequest {

    private String creditForeignHostMDR;
    private String creditForeignMerchantMDR;
    private String creditForeignMobiMDR;
    private String debitForeignHostMDR;
    private String debitForeignMerchantMDR;
    private String debitForeignMobiMDR;
}
