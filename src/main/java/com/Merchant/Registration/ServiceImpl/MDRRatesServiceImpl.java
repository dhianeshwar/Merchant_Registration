package com.Merchant.Registration.ServiceImpl;

import com.Merchant.Registration.Exception.BadRequestException;
import com.Merchant.Registration.Repository.MdrRatesRepository;
import com.Merchant.Registration.Service.MDRRatesService;
import com.Merchant.Registration.Utility.EntityMapper;
import com.Merchant.Registration.Utility.NumberValidation;
import com.Merchant.Registration.Utility.RetrieveProperties;
import com.Merchant.Registration.entity.MdrRates;
import com.Merchant.Registration.request.MdrRatesRequest;
import org.springframework.stereotype.Service;

import java.security.SecureRandom;

@Service
public class MDRRatesServiceImpl implements MDRRatesService {
    private final MdrRatesRepository mdrRatesRepository;

    public MDRRatesServiceImpl(MdrRatesRepository mdrRatesRepository)
    {
        this.mdrRatesRepository=mdrRatesRepository;
    }

    @Override
    public MdrRates addNewMdrRates(MdrRatesRequest request,String mid) {
        validateRequest(request);
        MdrRates mdrRates=convertToEntityUsingMapper(request);
        SecureRandom secureRandom=new SecureRandom();
        mdrRates.setId(secureRandom.nextLong());
        mdrRates.setMidMapped(mid);
        System.out.println(mdrRates.toString());
        try {
            mdrRatesRepository.save(mdrRates);
        }catch (Exception e)
        {
            System.out.println(e.getMessage());
            e.printStackTrace();
        }
        return mdrRates;
    }

    private void validateRequest(MdrRatesRequest request)
    {
        if(!NumberValidation.areAllValidFloats(RetrieveProperties.getAllFloatValues(request)))
            throw new BadRequestException("Not a valid MDR rates");
    }
    public MdrRates convertToEntityUsingMapper(MdrRatesRequest request) {
        return EntityMapper.INSTANCE.requestToEntity(request);
    }
}

