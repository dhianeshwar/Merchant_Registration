package com.Merchant.Registration.ServiceImpl;

import com.Merchant.Registration.Exception.BadRequestException;
import com.Merchant.Registration.Repository.MdrRatesRepository;
import com.Merchant.Registration.Repository.MobiMdrRepository;
import com.Merchant.Registration.Service.MDRRatesService;
import com.Merchant.Registration.Utility.EntityMapper;
import com.Merchant.Registration.Utility.FloatValidation;
import com.Merchant.Registration.entity.MdrRates;
import com.Merchant.Registration.entity.MobiMdr;
import com.Merchant.Registration.request.*;
import jakarta.transaction.Transactional;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

@Service
public class MDRRatesServiceImpl implements MDRRatesService {
    private final MobiMdrRepository mobiMdrRepository;

    public MDRRatesServiceImpl(MobiMdrRepository mobiMdrRepository)
    {
        this.mobiMdrRepository=mobiMdrRepository;
    }

    @Override
    @Transactional
    public MobiMdr addNewMdrRates(ServiceNeeded request, MdrRequest mdrs, String mid,String cardBrand) {

        MobiMdr mobiMdr = new MobiMdr();
        mobiMdr.setMid(mid);
        //new Validation
        if (request != null) {
            if (request.isBoostNeeded() || request.isBnplNeeded() || request.isTngNeeded() || request.isFpxNeeded() || request.isGrabNeeded() || request.isLocalCardNeeded() || request.isForeignCardNeeded()) {
                if (mdrs == null) {
                    throw new BadRequestException("MDR RATES NOT PROVIDED");
                }
                if (request.isBoostNeeded() || request.isGrabNeeded() || request.isTngNeeded() || request.isSppNeeded()) {
                    if (mdrs.getEwalletMdr() == null)
                        throw new BadRequestException("E-WALLET MDR rates not provided");
                }
            }
        }

            if (!StringUtils.isBlank(cardBrand)) {
                if (cardBrand.equalsIgnoreCase("MASTERCARD") ||
                        cardBrand.equalsIgnoreCase("UNIONPAY") ||
                        cardBrand.equalsIgnoreCase("VISA"))
                    mobiMdr.setCardBrand(cardBrand);
                else
                    throw new BadRequestException("INVALID CARD BRAND");
            }

            if (request.isBoostNeeded()) {
                BoostMdrRequest boostMdrRequest = mdrs.getEwalletMdr().getBoostMdrRequest();
                if (boostMdrRequest == null) {
                    throw new BadRequestException("boost mdr values not provided");
                }
                FloatValidation.validate(boostMdrRequest);
                mobiMdr.setBoostQrHostMDR(Float.parseFloat(boostMdrRequest.getBoostQrHostMDR()));
                mobiMdr.setBoostQrMerchantMDR(Float.parseFloat(boostMdrRequest.getBoostQrMerchantMDR()));
                mobiMdr.setBoostQrMobiMDR(Float.parseFloat(boostMdrRequest.getBoostQrMobiMDR()));
                mobiMdr.setBoostEcomHostMDR(Float.parseFloat(boostMdrRequest.getBoostEcomHostMDR()));
                mobiMdr.setBoostEcomMerchantMDR(Float.parseFloat(boostMdrRequest.getBoostEcomMerchantMDR()));
                mobiMdr.setBoostEcomMobiMDR(Float.parseFloat(boostMdrRequest.getBoostEcomMobiMDR()));
            }
            if (request.isGrabNeeded()) {
                GrabMdrRequest grabMdrRequest = mdrs.getEwalletMdr().getGrabMdrRequest();
                if (grabMdrRequest == null) {
                    throw new BadRequestException("Grab MDR values not provided");
                }
                FloatValidation.validate(grabMdrRequest);

                mobiMdr.setGrabQrHostMDR(Float.parseFloat(grabMdrRequest.getGrabQrHostMDR()));
                mobiMdr.setGrabQrMerchantMDR(Float.parseFloat(grabMdrRequest.getGrabQrMerchantMDR()));
                mobiMdr.setGrabQrMobiMDR(Float.parseFloat(grabMdrRequest.getGrabQrMobiMDR()));
                mobiMdr.setGrabEcomHostMDR(Float.parseFloat(grabMdrRequest.getGrabEcomHostMDR()));
                mobiMdr.setGrabEcomMerchantMDR(Float.parseFloat(grabMdrRequest.getGrabEcomMerchantMDR()));
                mobiMdr.setGrabEcomMobiMDR(Float.parseFloat(grabMdrRequest.getGrabEcomMobiMDR()));
            }
            if (request.isTngNeeded()) {
                TngMdrRequest TngMdrRequest = mdrs.getEwalletMdr().getTngMdrRequest();
                if (TngMdrRequest == null) {
                    throw new BadRequestException("Tng MDR values not provided");
                }
                FloatValidation.validate(TngMdrRequest);

                mobiMdr.setTngQrHostMDR(Float.parseFloat(TngMdrRequest.getTngQrHostMDR()));
                mobiMdr.setTngQrMerchantMDR(Float.parseFloat(TngMdrRequest.getTngQrMerchantMDR()));
                mobiMdr.setTngQrMobiMDR(Float.parseFloat(TngMdrRequest.getTngQrMobiMDR()));
                mobiMdr.setTngEcomHostMDR(Float.parseFloat(TngMdrRequest.getTngEcomHostMDR()));
                mobiMdr.setTngEcomMerchantMDR(Float.parseFloat(TngMdrRequest.getTngEcomMerchantMDR()));
                mobiMdr.setTngEcomMobiMDR(Float.parseFloat(TngMdrRequest.getTngEcomMobiMDR()));
            }
            if (request.isBnplNeeded()) {
                BnplMdrRequest BnplMdrRequest = mdrs.getBnplMdr();
                if (BnplMdrRequest == null) {
                    throw new BadRequestException("Bnpl MDR values not provided");
                }
                FloatValidation.validate(BnplMdrRequest);

                mobiMdr.setBnplQrHostMDR(Float.parseFloat(BnplMdrRequest.getBnplQrHostMDR()));
                mobiMdr.setBnplQrMerchantMDR(Float.parseFloat(BnplMdrRequest.getBnplQrMerchantMDR()));
                mobiMdr.setBnplQrMobiMDR(Float.parseFloat(BnplMdrRequest.getBnplQrMobiMDR()));
                mobiMdr.setBnplEcomHostMDR(Float.parseFloat(BnplMdrRequest.getBnplEcomHostMDR()));
                mobiMdr.setBnplEcomMerchantMDR(Float.parseFloat(BnplMdrRequest.getBnplEcomMerchantMDR()));
                mobiMdr.setBnplEcomMobiMDR(Float.parseFloat(BnplMdrRequest.getBnplEcomMobiMDR()));
            }
            if (request.isFpxNeeded()) {
                FpxMdrRequest fpxMdrRequest = mdrs.getFpxMdr();

                if (fpxMdrRequest == null) {
                    throw new BadRequestException("FPX mdr values not provided");
                }
                FloatValidation.validate(fpxMdrRequest);
                mobiMdr.setFpxTxnMdr(Float.parseFloat(fpxMdrRequest.getFpxTxnMdr()));
                mobiMdr.setFpxMobiAmt(Float.parseFloat(fpxMdrRequest.getFpxMobiMdr()));
                mobiMdr.setFpxHostAmt(Float.parseFloat(fpxMdrRequest.getFpxHostMdr()));
                mobiMdr.setFpxMercAmt(Float.parseFloat(fpxMdrRequest.getFpxMerchantMdr()));
            }
            if (request.isForeignCardNeeded()) {
                ForeignCardRatesRequest foreignCardRatesRequest = mdrs.getForeignMdr();
                if (foreignCardRatesRequest == null) {
                    throw new BadRequestException("Foreign card Mdr Rates not provided");
                }
                FloatValidation.validate(foreignCardRatesRequest);
                mobiMdr.setCreditForeignHostMDR(Float.parseFloat(foreignCardRatesRequest.getCreditForeignHostMDR()));
                mobiMdr.setCreditForeignMerchantMDR(Float.parseFloat(foreignCardRatesRequest.getCreditForeignMerchantMDR()));
                mobiMdr.setCreditForeignMobiMDR(Float.parseFloat(foreignCardRatesRequest.getCreditForeignMobiMDR()));
                mobiMdr.setDebitForeignHostMDR(Float.parseFloat(foreignCardRatesRequest.getDebitForeignHostMDR()));
                mobiMdr.setDebitForeignMerchantMDR(Float.parseFloat(foreignCardRatesRequest.getDebitForeignMerchantMDR()));
                mobiMdr.setDebitForeignMobiMDR(Float.parseFloat(foreignCardRatesRequest.getDebitForeignMobiMDR()));

            }
            if (request.isLocalCardNeeded()) {
                LocalCardRatesRequest localCardRatesRequest = mdrs.getLocalCardMdr();
                if (localCardRatesRequest == null) {
                    throw new BadRequestException("Local card Mdr rates not provided");
                }
                FloatValidation.validate(localCardRatesRequest);
                mobiMdr.setCreditLocalHostMDR(Float.parseFloat(localCardRatesRequest.getCreditLocalHostMDR()));
                mobiMdr.setCreditLocalMerchantMDR(Float.parseFloat(localCardRatesRequest.getCreditLocalMerchantMDR()));
                mobiMdr.setCreditLocalMobiMDR(Float.parseFloat(localCardRatesRequest.getCreditLocalMobiMDR()));
                mobiMdr.setDebitLocalHostMDR(Float.parseFloat(localCardRatesRequest.getDebitLocalHostMDR()));
                mobiMdr.setDebitLocalMerchantMDR(Float.parseFloat(localCardRatesRequest.getDebitLocalMerchantMDR()));
                mobiMdr.setDebitLocalMobiMDR(Float.parseFloat(localCardRatesRequest.getDebitLocalMobiMDR()));

            }
            System.out.println(mobiMdr);
            try {
                mobiMdrRepository.save(mobiMdr);
            } catch (Exception e) {
                System.out.println(e.getMessage());
                e.printStackTrace();
            }
            return mobiMdr;

        }
}

