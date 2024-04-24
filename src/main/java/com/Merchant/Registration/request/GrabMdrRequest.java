package com.Merchant.Registration.request;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class GrabMdrRequest {
    private String grabQrHostMDR;
    private String grabQrMerchantMDR;
    private String grabQrMobiMDR;
    private String grabEcomHostMDR;
    private String grabEcomMerchantMDR;
    private String grabEcomMobiMDR;
}
