package com.Merchant.Registration.ServiceImpl;

import com.Merchant.Registration.Repository.MobileUserRepository;
import com.Merchant.Registration.Service.MobileUserService;
import com.Merchant.Registration.entity.Merchant;
import com.Merchant.Registration.entity.MobileUser;
import com.Merchant.Registration.request.ServiceNeeded;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.security.MessageDigest;
import java.security.SecureRandom;
import java.util.Arrays;
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
//        newMobileUser.setUsername(merchant.getUsername());
        newMobileUser.setDateOfBirth(merchant.getDateOfBirth());
        newMobileUser.setPassword(merchant.getPassword());
        newMobileUser.setEnableSettelementPayout("No");
        newMobileUser.setPermissionSettle(false);
        newMobileUser.setPermissionVoid(false);

        String boostTid=null,grabTid=null,tngTid=null,shoppyTid=null,TidString=null,ezyWayTid=null,motoTid=null,bnplTid=null;


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
                if (request.isEzyWayNeeded())
                    ezyWayTid = generateUniqueRandomString();
                if (request.isEzyMotoNeeded())
                    motoTid = generateUniqueRandomString();
                if(request.isBnplNeeded())
                    bnplTid=generateUniqueRandomString();

                TidString = generateUniqueRandomString();

                existingTid = mobileUserRepository.existsBYAnyTids(TidString, boostTid, grabTid, tngTid, shoppyTid,ezyWayTid,motoTid,bnplTid);
            } while (!existingTid.isEmpty());

        }

        System.out.println("Tid : "+TidString);
        System.out.println("BOOST Tid : "+boostTid);
        System.out.println("GRAB Tid : "+grabTid);
        System.out.println("TNG Tid : "+tngTid);
        System.out.println("SHOPPY Tid : "+shoppyTid);
        System.out.println("EZYWAY Tid : "+ezyWayTid);
        System.out.println("MOTO Tid : "+motoTid);

        String mobileUserName=merchant.getBusinessShortName().substring(0,4)+TidString.substring(TidString.length()-5);
        String motoApiKey=getMD5Hash(TidString);

        System.out.println("MOTO API KEY --->"+motoApiKey);



        newMobileUser.setTid(TidString);
        newMobileUser.setBoostTid(boostTid);
        newMobileUser.setGpayTid(grabTid);
        newMobileUser.setTngTid(tngTid);
        newMobileUser.setShoppyTid(shoppyTid);
        newMobileUser.setEzywayTid(ezyWayTid);
        newMobileUser.setMotoTid(motoTid);
        newMobileUser.setBnplTid(bnplTid);
        newMobileUser.setFailedLoginAttempt(0);
        newMobileUser.setUsername(mobileUserName);
        newMobileUser.setMotoApiKey(motoApiKey);

        try{
            System.out.println(newMobileUser);
            mobileUserRepository.insertMobileUser(TidString,boostTid,grabTid,tngTid,shoppyTid,ezyWayTid,motoTid,bnplTid,merchantId,false,false,mobileUserName,merchant.getPassword());
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
    public static String getMD5Hash(String data) {
//        logger.info("inside getmd5hash");
        String result = null;
        try {
            MessageDigest digest = MessageDigest.getInstance("MD5");
            byte[] hash = digest.digest(data.getBytes("UTF-8"));
//            logger.info("sending to  bytesToHex");
            return bytesToHex(hash); // make it printable
        }catch(Exception ex) {
            ex.printStackTrace();
        }
        return result;
    }
    public static String bytesToHex(byte[] hash) {
        StringBuilder hexString = new StringBuilder(2 * hash.length);
        for (byte b : hash) {
            String hex = Integer.toHexString(0xff & b);
            if (hex.length() == 1) {
                hexString.append('0');
            }
            hexString.append(hex);
        }
        return hexString.toString();
    }

    public static void main(String[] args) {
        System.out.println(getMD5Hash("88743176"));
    }
}
