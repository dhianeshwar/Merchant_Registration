package com.Merchant.Registration.Service;

import com.Merchant.Registration.entity.MdrRates;
import com.Merchant.Registration.request.MdrRatesRequest;
import com.Merchant.Registration.request.MerchantRequest;

public interface MDRRatesService {
    MdrRates addNewMdrRates(MdrRatesRequest request,String mid);
}
