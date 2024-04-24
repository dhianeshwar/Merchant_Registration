package com.Merchant.Registration.Service;

import com.Merchant.Registration.entity.MID;
import com.Merchant.Registration.entity.Merchant;
import com.Merchant.Registration.request.ServiceNeeded;

public interface MIDService {
     MID generateMid(ServiceNeeded serviceNeeded, Merchant merchant);
     long findIdBYShoppyMid(String shoppyMid);
}
