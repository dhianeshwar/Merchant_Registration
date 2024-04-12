package com.Merchant.Registration.ServiceImpl;

import com.Merchant.Registration.Repository.MidRepository;
import com.Merchant.Registration.Service.MIDService;
import com.Merchant.Registration.entity.MID;
import org.springframework.stereotype.Service;

import java.security.SecureRandom;
import java.util.Set;

@Service
public class MIDServiceImpl implements MIDService {

    private final MidRepository midRepository;

    public MIDServiceImpl(MidRepository midRepository) {
        this.midRepository = midRepository;
    }

    public MID generateMid() {
        Set<String> existingStrings = midRepository.findAllUniqueMIDs();

        System.out.println("LENGTH OF THE SET :  "+existingStrings.size());

        String boostMid = "BST"+generateUniqueRandomString(existingStrings, 12);
        String grabMid = "GRB"+generateUniqueRandomString(existingStrings, 12);
        String tngMid = "TNG"+generateUniqueRandomString(existingStrings, 12);
        String shoppyMid = "SPP"+generateUniqueRandomString(existingStrings, 12);
        String midString = generateUniqueRandomString(existingStrings, 16);

        System.out.println("MID : "+midString);
        System.out.println("BOOST MID : "+boostMid);
        System.out.println("GRAB MID : "+grabMid);
        System.out.println("TNG MID : "+tngMid);
        System.out.println("SHOPPY MID : "+shoppyMid);


        MID newMid = new MID();

        newMid.setMid(midString);
        newMid.setBoostMid(boostMid);
        newMid.setGrabMid(grabMid);
        newMid.setTngMid(tngMid);
        newMid.setShoppyMid(shoppyMid);

        midRepository.insertMID(boostMid,grabMid,tngMid,shoppyMid,midString);

        return newMid;
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
