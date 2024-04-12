package com.Merchant.Registration.ServiceImpl;

import com.Merchant.Registration.Repository.MobileUserRepository;
import com.Merchant.Registration.Service.MobileUserService;
import com.Merchant.Registration.entity.Merchant;
import com.Merchant.Registration.entity.MobileUser;
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
    public MobileUser generateTid(Merchant merchant,long merchantId) {
        String boostTid,grabTid,tngTid,shoppyTid,TidString,userName,password;
        boolean permissionSettle= false;
        boolean permissionVoid= false;
        List<String> existingTid ;

        do
        {
             boostTid = generateUniqueRandomString();
             grabTid = generateUniqueRandomString();
             tngTid = generateUniqueRandomString();
             shoppyTid = generateUniqueRandomString();
             TidString = generateUniqueRandomString();

            existingTid=mobileUserRepository.existsBYAnyTids(TidString,boostTid,grabTid,tngTid,shoppyTid);
        }while (!existingTid.isEmpty());



        System.out.println("Tid : "+TidString);
        System.out.println("BOOST Tid : "+boostTid);
        System.out.println("GRAB Tid : "+grabTid);
        System.out.println("TNG Tid : "+tngTid);
        System.out.println("SHOPPY Tid : "+shoppyTid);

        userName=merchant.getUsername();
        password=merchant.getPassword();

        MobileUser newMobileUser = new MobileUser();

        newMobileUser.setTid(TidString);
        newMobileUser.setBoostTid(boostTid);
        newMobileUser.setGpayTid(grabTid);
        newMobileUser.setTngTid(tngTid);
        newMobileUser.setShoppyTid(shoppyTid);
        newMobileUser.setUsername(userName);
        newMobileUser.setPassword(password);


        try{
            mobileUserRepository.insertMobileUser(TidString,boostTid,grabTid,tngTid,shoppyTid,merchantId,permissionSettle,permissionVoid,userName,password);
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
