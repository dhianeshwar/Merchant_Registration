package com.Merchant.Registration.Utility;

import com.Merchant.Registration.entity.MdrRates;
import com.Merchant.Registration.entity.Merchant;
import com.Merchant.Registration.entity.MobiMdr;
import com.Merchant.Registration.request.MdrRatesRequest;
import com.Merchant.Registration.request.MerchantRequest;
import com.Merchant.Registration.request.MobiMdrRequest;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface EntityMapper {
    EntityMapper INSTANCE = Mappers.getMapper(EntityMapper.class);

    MdrRates requestToEntity(MdrRatesRequest request);
//    Merchant requestToEntity(MerchantRequest request);

    MobiMdr requestToEntity(MobiMdrRequest request);
}
