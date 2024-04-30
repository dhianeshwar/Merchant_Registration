package com.Merchant.Registration.request;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class ServiceNeeded {
    private boolean boostNeeded;
    private boolean grabNeeded;
    private boolean tngNeeded;
    private boolean sppNeeded;
    private boolean foreignCardNeeded;
    private boolean localCardNeeded;
    private boolean fpxNeeded;
    private boolean bnplNeeded;
    private boolean ezyMotoNeeded;
    private boolean ezyWayNeeded;

}
