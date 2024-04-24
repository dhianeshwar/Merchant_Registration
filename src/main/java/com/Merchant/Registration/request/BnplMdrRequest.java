package com.Merchant.Registration.request;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class BnplMdrRequest {
    private String bnplQrHostMDR;
    private String bnplQrMerchantMDR;
    private String bnplQrMobiMDR;
    private String bnplEcomHostMDR;
    private String bnplEcomMerchantMDR;
    private String bnplEcomMobiMDR;
}
