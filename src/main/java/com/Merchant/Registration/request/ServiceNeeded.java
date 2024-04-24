package com.Merchant.Registration.request;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ServiceNeeded {
    private boolean boostNeeded;
    private boolean grabNeeded;
    private boolean tngNeeded;
    private boolean sppNeeded;
    private boolean foreignCardNeeded;
    private boolean localCardNeeded;
    private boolean fpxNeeded;
    private boolean bnplNeeded;
}
