package com.Merchant.Registration.request;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class TngMdrRequest {
    private String tngQrHostMDR;
    private String tngQrMerchantMDR;
    private String tngQrMobiMDR;
    private String tngEcomHostMDR;
    private String tngEcomMerchantMDR;
    private String tngEcomMobiMDR;
}
