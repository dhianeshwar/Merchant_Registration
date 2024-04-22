package com.Merchant.Registration.Service;

import com.Merchant.Registration.entity.MdrRates;
import com.Merchant.Registration.entity.MobiMdr;
import com.Merchant.Registration.request.MerchantRequest;
import com.Merchant.Registration.request.MobiMdrRequest;

public interface MdrService
{
    MobiMdr insertMobiMdr(MobiMdrRequest mdrRequest,String mid);

}
