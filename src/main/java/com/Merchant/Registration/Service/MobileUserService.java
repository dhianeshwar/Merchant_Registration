package com.Merchant.Registration.Service;

import com.Merchant.Registration.entity.Merchant;
import com.Merchant.Registration.entity.MobileUser;
import com.Merchant.Registration.request.ServiceNeeded;

public interface MobileUserService {
    MobileUser generateTid(Merchant merchant, ServiceNeeded request,long merchantId);

}
