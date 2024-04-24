package com.Merchant.Registration.request;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class BoostMdrRequest {
    private String boostQrHostMDR;
    private String boostQrMerchantMDR;
    private String boostQrMobiMDR;
    private String boostEcomHostMDR;
    private String boostEcomMerchantMDR;
    private String boostEcomMobiMDR;
}
