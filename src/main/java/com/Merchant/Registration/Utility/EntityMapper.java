package com.Merchant.Registration.Utility;

import com.Merchant.Registration.entity.MdrRates;
import com.Merchant.Registration.entity.MobiMdr;
import com.Merchant.Registration.request.MdrRatesRequest;
import com.Merchant.Registration.request.MobiMdrRequest;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public interface EntityMapper {
    EntityMapper INSTANCE = Mappers.getMapper(EntityMapper.class);
    @Mapping(target = "id", ignore = true)
    @Mapping(target = "productId", ignore = true)
    @Mapping(target = "rateId", ignore = true)
    @Mapping(target = "validFrom", ignore = true)
    @Mapping(target = "validTo", ignore = true)
    @Mapping(target = "midMapped", ignore = true)
    @Mapping(target = "timeStamp", ignore = true)
    MdrRates requestToEntity(MdrRatesRequest request);
//    Merchant requestToEntity(MerchantRequest request);

    MobiMdr requestToEntity(MobiMdrRequest request);
}
