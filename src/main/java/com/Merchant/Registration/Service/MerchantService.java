package com.Merchant.Registration.Service;

import com.Merchant.Registration.Response.RegResponse;
import com.Merchant.Registration.entity.Merchant;
import com.Merchant.Registration.entity.MerchantUserRole;
import com.Merchant.Registration.request.MerchantRequest;

public interface MerchantService {
    String getMerchantBusinessShortNameByID(Long id);
    Merchant getMerchantByID(Long id);

    RegResponse addNewMerchant(MerchantRequest request);
     void isValidDate(String dateString, String dateFormat);

    RegResponse updateExistingMerchant(MerchantRequest request);

    RegResponse softDeleteMerchant(Long id);
}
