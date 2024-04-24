package com.Merchant.Registration.Service;

import com.Merchant.Registration.entity.MID;
import com.Merchant.Registration.entity.MdrRates;
import com.Merchant.Registration.entity.MobiMdr;
import com.Merchant.Registration.request.MdrRatesRequest;
import com.Merchant.Registration.request.MdrRequest;
import com.Merchant.Registration.request.MerchantRequest;
import com.Merchant.Registration.request.ServiceNeeded;

public interface MDRRatesService {
    MobiMdr addNewMdrRates(ServiceNeeded request, MdrRequest mdr, String mid,String cardBrand);
}
