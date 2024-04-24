package com.Merchant.Registration.request;

import lombok.Getter;
import lombok.Setter;
@Getter
@Setter
public class MdrRequest {
    private EwalletMdrRequest ewalletMdr;
    private FpxMdrRequest fpxMdr;
    private ForeignCardRatesRequest foreignMdr;
    private LocalCardRatesRequest localCardMdr;
    private BnplMdrRequest bnplMdr;
}
