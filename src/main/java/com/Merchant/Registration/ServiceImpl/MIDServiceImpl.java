package com.Merchant.Registration.ServiceImpl;

import com.Merchant.Registration.Repository.MidRepository;
import com.Merchant.Registration.Service.MIDService;
import com.Merchant.Registration.entity.MID;
import com.Merchant.Registration.entity.Merchant;
import com.Merchant.Registration.request.ServiceNeeded;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.security.SecureRandom;
import java.util.Set;

@Service
public class MIDServiceImpl implements MIDService {

    private final MidRepository midRepository;

    public MIDServiceImpl(MidRepository midRepository) {
        this.midRepository = midRepository;
    }

    @Transactional
    public MID generateMid(ServiceNeeded serviceNeeded, Merchant merchant) {
        System.out.println("Required Services::::"+serviceNeeded);
        Set<String> existingStrings = midRepository.findAllUniqueMIDs();
        MID mid = new MID();
        System.out.println("LENGTH OF THE SET :  "+existingStrings.size());
        String midString = generateUniqueRandomString(existingStrings, 16);
        System.out.println("MID : "+midString);
        mid.setMid(midString);

        if(serviceNeeded!=null) {
            if (serviceNeeded.isBoostNeeded()) {
                String boostMid = "BST" + generateUniqueRandomString(existingStrings, 12);
                System.out.println("BOOST MID : " + boostMid);
                mid.setBoostMid(boostMid);
            }

            if (serviceNeeded.isGrabNeeded()) {
                String grabMid = "GRB" + generateUniqueRandomString(existingStrings, 12);
                System.out.println("GRAB MID : " + grabMid);
                mid.setGrabMid(grabMid);

            }
            if (serviceNeeded.isTngNeeded()) {
                String tngMid = "TNG" + generateUniqueRandomString(existingStrings, 12);
                System.out.println("TNG MID : " + tngMid);
                mid.setTngMid(tngMid);

            }
            if (serviceNeeded.isSppNeeded()) {
                String shoppyMid = "SPP" + generateUniqueRandomString(existingStrings, 12);
                System.out.println("SHOPPY MID : " + shoppyMid);
                mid.setShoppyMid(shoppyMid);
            }
            if (serviceNeeded.isFpxNeeded()) {
                String fpxMid = "FPX" + generateUniqueRandomString(existingStrings, 12);
                System.out.println("FPX MID : " + fpxMid);
                mid.setFpxMid(fpxMid);
            }
            if (serviceNeeded.isBnplNeeded()) {
                String bnplMid = "BNP" + generateUniqueRandomString(existingStrings, 12);
                System.out.println("BNPL MID : " + bnplMid);
                mid.setBnplMid(bnplMid);
            }
            if (serviceNeeded.isLocalCardNeeded() || serviceNeeded.isForeignCardNeeded()) {
                String ezywayMid = "EZYWAY" + generateUniqueRandomString(existingStrings, 12);
                System.out.println("EZYWAY MID : " + ezywayMid);
                mid.setEzywayMid(ezywayMid);
            }
            if (serviceNeeded.isEzyMotoNeeded()) {
                String ezyMoto = "MOTO" + generateUniqueRandomString(existingStrings, 12);
                System.out.println("UM MOTO MID : " + ezyMoto);
                mid.setUmMotoMid(ezyMoto);
            }
            if (serviceNeeded.isEzyWayNeeded()) {
                String ezyWay = "WAY" + generateUniqueRandomString(existingStrings, 12);
                System.out.println("UM EZYWAY MID : " + ezyWay);
                mid.setUmEzywayMid(ezyWay);
            }

        }
//        mid.setMerchant(merchant);
        return midRepository.save(mid);

    }

    private String generateUniqueRandomString(Set<String> existingStrings, int length) {
        SecureRandom secureRandom = new SecureRandom();
        String randomString;

        do {
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < length; i++) {
                sb.append(secureRandom.nextInt(10));
            }
            randomString = sb.toString();
        } while (existingStrings.contains(randomString));

        existingStrings.add(randomString);

        return randomString;
    }
    @Override
    public long findIdBYShoppyMid(String shoppyMid)
    {
        return midRepository.findID(shoppyMid);
    }
}
