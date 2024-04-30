package com.Merchant.Registration.Service;

import com.Merchant.Registration.entity.MID;
import com.Merchant.Registration.entity.Merchant;
import com.Merchant.Registration.entity.MobileUser;
import com.Merchant.Registration.request.ServiceNeeded;

import java.util.Map;

public interface TerminalDetailsService {
    Map<String,String> addTerminalDetails(ServiceNeeded request, MID mid, MobileUser mobileUser, Merchant merchant);
}
