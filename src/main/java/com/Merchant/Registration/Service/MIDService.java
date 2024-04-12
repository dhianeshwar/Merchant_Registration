package com.Merchant.Registration.Service;

import com.Merchant.Registration.entity.MID;

public interface MIDService {
     MID generateMid();
     long findIdBYShoppyMid(String shoppyMid);
}
