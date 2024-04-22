package com.Merchant.Registration.ServiceImpl;

import com.Merchant.Registration.Exception.BadRequestException;
import com.Merchant.Registration.Repository.MobiMdrRepository;
import com.Merchant.Registration.Service.MdrService;
import com.Merchant.Registration.Utility.NumberValidation;
import com.Merchant.Registration.Utility.RetrieveProperties;
import com.Merchant.Registration.entity.MdrRates;
import com.Merchant.Registration.entity.MobiMdr;
import com.Merchant.Registration.request.MerchantRequest;
import com.Merchant.Registration.request.MobiMdrRequest;
import org.springframework.stereotype.Service;

import java.security.SecureRandom;

@Service
public class MdrServiceImpl implements MdrService {
    private final MobiMdrRepository mobiMdrRepository;

    public MdrServiceImpl(MobiMdrRepository mobiMdrRepository) {
        this.mobiMdrRepository = mobiMdrRepository;
    }


    @Override
    public MobiMdr insertMobiMdr(MobiMdrRequest request,String mid) {
        validateRequest(request);
       MobiMdr mobiMdr=requestToEntity(request);
        System.out.println("mapped mid in Mobiversa_mdr table ::"+mid);
       mobiMdr.setMid(mid);
        try {
            mobiMdrRepository.save(mobiMdr);
        }
        catch (Exception e)
        {
            System.out.println(e.getMessage());
            throw new BadRequestException("Exception while inserting in Mdr Rates table ");
        }
        return mobiMdr;
    }


    private void validateRequest(MobiMdrRequest request) {
        if(!NumberValidation.areAllValidFloats(RetrieveProperties.getAllFloatValues(request)))
            throw new BadRequestException("Not a valid MDR rates");
    }


    private static MobiMdr requestToEntity(MobiMdrRequest request)
    {
        SecureRandom secureRandom = new SecureRandom();

        MobiMdr entity=new MobiMdr();
        entity.setBoostQrHostMDR(Float.parseFloat(request.getBoostQrHostMDR()));
        entity.setBoostQrMerchantMDR(Float.parseFloat(request.getBoostQrMerchantMDR()));
        entity.setBoostQrMobiMDR(Float.parseFloat(request.getBoostQrMobiMDR()));
        entity.setBoostEcomHostMDR(Float.parseFloat(request.getBoostEcomHostMDR()));
        entity.setBoostEcomMerchantMDR(Float.parseFloat(request.getBoostEcomMerchantMDR()));
        entity.setBoostEcomMobiMDR(Float.parseFloat(request.getBoostEcomMobiMDR()));
        entity.setGrabQrHostMDR(Float.parseFloat(request.getGrabQrHostMDR()));
        entity.setGrabQrMerchantMDR(Float.parseFloat(request.getGrabQrMerchantMDR()));
        entity.setGrabQrMobiMDR(Float.parseFloat(request.getGrabQrMobiMDR()));
        entity.setGrabEcomHostMDR(Float.parseFloat(request.getGrabEcomHostMDR()));
        entity.setGrabEcomMerchantMDR(Float.parseFloat(request.getGrabEcomMerchantMDR()));
        entity.setGrabEcomMobiMDR(Float.parseFloat(request.getGrabEcomMobiMDR()));
        entity.setTngQrHostMDR(Float.parseFloat(request.getTngQrHostMDR()));
        entity.setTngQrMerchantMDR(Float.parseFloat(request.getTngQrMerchantMDR()));
        entity.setTngQrMobiMDR(Float.parseFloat(request.getTngQrMobiMDR()));
        entity.setTngEcomHostMDR(Float.parseFloat(request.getTngEcomHostMDR()));
        entity.setTngEcomMerchantMDR(Float.parseFloat(request.getTngEcomMerchantMDR()));
        entity.setTngEcomMobiMDR(Float.parseFloat(request.getTngEcomMobiMDR()));
//        entity.setId(secureRandom.nextLong());
        return entity;
    }
}
