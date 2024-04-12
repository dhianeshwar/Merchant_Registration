package com.Merchant.Registration.Service;

import com.Merchant.Registration.entity.Merchant;
import com.Merchant.Registration.entity.MobileUser;

public interface MobileUserService {
    MobileUser generateTid(Merchant merchant,long id);

}
