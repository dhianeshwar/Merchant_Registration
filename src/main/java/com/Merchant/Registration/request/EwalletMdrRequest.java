package com.Merchant.Registration.request;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class EwalletMdrRequest {
    private BoostMdrRequest boostMdrRequest;
    private TngMdrRequest tngMdrRequest;
    private GrabMdrRequest grabMdrRequest;

}
