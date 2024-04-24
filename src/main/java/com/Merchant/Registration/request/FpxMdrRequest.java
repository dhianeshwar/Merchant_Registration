package com.Merchant.Registration.request;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class FpxMdrRequest {

    private String fpxTxnMdr;
    private String fpxMobiMdr;
    private String fpxMerchantMdr;
    private String fpxHostMdr;

}
