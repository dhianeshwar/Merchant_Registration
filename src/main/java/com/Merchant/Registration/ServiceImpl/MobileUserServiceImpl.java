package com.Merchant.Registration.ServiceImpl;

import com.Merchant.Registration.Repository.MobileUserRepository;
import com.Merchant.Registration.Service.MobileUserService;
import com.Merchant.Registration.entity.Merchant;
import com.Merchant.Registration.entity.MobileUser;
import com.Merchant.Registration.request.ServiceNeeded;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.security.SecureRandom;
import java.util.List;

@Service
public class MobileUserServiceImpl implements MobileUserService {
    private final MobileUserRepository mobileUserRepository;

    public MobileUserServiceImpl(MobileUserRepository mobileUserRepository)
    {
        this.mobileUserRepository=mobileUserRepository;
    }
    @Override
    @Transactional
    public MobileUser generateTid(Merchant merchant,ServiceNeeded request,long merchantId) {
        MobileUser newMobileUser = new MobileUser();

        newMobileUser.setStatus(merchant.getStatus());
        newMobileUser.setEmail(merchant.getEmail());
        newMobileUser.setUsername(merchant.getUsername());
        newMobileUser.setDateOfBirth(merchant.getDateOfBirth());
        newMobileUser.setPassword(merchant.getPassword());
        newMobileUser.setEnableSettelementPayout("No");
        newMobileUser.setPermissionSettle(false);
        newMobileUser.setPermissionVoid(false);

        String boostTid=null,grabTid=null,tngTid=null,shoppyTid=null,TidString=null;


        List<String> existingTid ;
        if(request!=null) {
            do {
                if (request.isBoostNeeded())
                    boostTid = generateUniqueRandomString();
                if (request.isGrabNeeded())
                    grabTid = generateUniqueRandomString();
                if (request.isTngNeeded())
                    tngTid = generateUniqueRandomString();
                if (request.isSppNeeded())
                    shoppyTid = generateUniqueRandomString();
                TidString = generateUniqueRandomString();

                existingTid = mobileUserRepository.existsBYAnyTids(TidString, boostTid, grabTid, tngTid, shoppyTid);
            } while (!existingTid.isEmpty());

        }

        System.out.println("Tid : "+TidString);
        System.out.println("BOOST Tid : "+boostTid);
        System.out.println("GRAB Tid : "+grabTid);
        System.out.println("TNG Tid : "+tngTid);
        System.out.println("SHOPPY Tid : "+shoppyTid);



        newMobileUser.setTid(TidString);
        newMobileUser.setBoostTid(boostTid);
        newMobileUser.setGpayTid(grabTid);
        newMobileUser.setTngTid(tngTid);
        newMobileUser.setShoppyTid(shoppyTid);
        newMobileUser.setFailedLoginAttempt(0);

        try{
            System.out.println(newMobileUser);
            mobileUserRepository.insertMobileUser(TidString,boostTid,grabTid,tngTid,shoppyTid,merchantId,false,false,merchant.getUsername(),merchant.getPassword());
            System.out.println("Mobile user saved with MERCHANT Mapped");
        }

        catch (Exception e)
        {
            e.printStackTrace();
            System.out.println("ACTUAL REASON CAUSING ERROR--->"+e.getMessage());
        }
        return newMobileUser;
    }
    private String generateUniqueRandomString() {
        SecureRandom secureRandom = new SecureRandom();
        StringBuilder sb = new StringBuilder();
            for (int i = 0; i < 8; i++) {
                sb.append(secureRandom.nextInt(10));
            }
        return sb.toString();
    }
}
