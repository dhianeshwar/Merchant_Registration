package com.Merchant.Registration.ServiceImpl;

import com.Merchant.Registration.Exception.BadRequestException;
import com.Merchant.Registration.Repository.MerchantRepository;
import com.Merchant.Registration.Repository.MidRepository;
import com.Merchant.Registration.Repository.MobileUserRepository;
import com.Merchant.Registration.Response.RegResponse;
import com.Merchant.Registration.Service.*;
import com.Merchant.Registration.entity.MID;
import com.Merchant.Registration.entity.Merchant;
import com.Merchant.Registration.entity.MerchantUserRole;
import com.Merchant.Registration.entity.MobileUser;
import com.Merchant.Registration.request.MerchantRequest;
import jakarta.transaction.Transactional;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.text.SimpleDateFormat;
import java.util.Map;
import java.util.Optional;

@Service
public class MerchantServiceImpl implements MerchantService {
    @Autowired
    private MerchantRepository merchantRepository;
    @Autowired
    private MidRepository midRepository;

    @Autowired
    private MIDService midService;
    @Autowired
    private MobileUserRepository mobileUserRepository;

    @Autowired
    private MobileUserService mobileUserService;

    @Autowired
    private MdrService mdrService;
    @Autowired
    private MDRRatesService mdrRatesService;

    @Autowired
    private TerminalDetailsService terminalDetailsService;

    @Override
    public String getMerchantBusinessShortNameByID(Long id) {
        return merchantRepository.getBusinessShortName(id);
    }


    @Override
    public Merchant getMerchantByID(Long id)
    {
        Optional<Merchant> optionalMerchant=merchantRepository.findById(id);
        return optionalMerchant.orElse(null);
    }

    @Override
    @Transactional
    public RegResponse addNewMerchant(MerchantRequest request) {

        validateRequest(request);

        Merchant merchant=requestToMerchant(request);
        merchant.setPayOutGrandDetailFk(null);
        merchant.setFailedLoginAttempt(0);


        System.out.println("MID GENERATION START");
        MID mid=midService.generateMid(request.getServiceNeeded(),merchant);//inserted mid without merchant
        merchant.setMid(mid);
        System.out.println("MID SAVED SUCCESSFULLY -->"+mid);
        System.out.println("SAVED MID WITH THR REQUIRED SERVICE WITH MERCHANT MAPPED");

        System.out.println("Adding Mdr Rates ");
        if(request.getServiceNeeded()!=null) {
            mdrRatesService.addNewMdrRates(request.getServiceNeeded(), request.getMdrRates(), mid.getMid(), request.getCardType());
            System.out.println("Saved Mdr Rates in the MOBIVERSA_MDR table");
        }


        try
        {
            System.out.println("Id for the MID table----->"+mid.getId());
            merchantRepository.addMerchantNativeQuery(merchant,mid.getId());//added merchant with MID
        }
        catch (Exception e)
        {
            e.printStackTrace();
            System.out.println("ACTUAL REASON CAUSING ERROR--> "+e.getMessage());
            return new RegResponse("error","Exception while inserting ");
        }
        long merchantIdFk=merchantRepository.findIdByMid_fk(mid.getId());
        MobileUser mobileUser=mobileUserService.generateTid(merchant,request.getServiceNeeded(),merchantIdFk);
        System.out.println("MOBILE USER Inserted Successfully");


        midRepository.mapMerchant(merchantIdFk,mid.getMid());
        System.out.println("Merchant Mapped with MID");

        Map<String,String> response=terminalDetailsService.addTerminalDetails(request.getServiceNeeded(), mid, mobileUser,merchant);
        if(response!=null)
            System.out.println("Terminal details added Successfully");



        return new RegResponse("Success","successFully inserted with the merchant id  :"+merchantIdFk,response);
    }

    @Override
    public RegResponse updateExistingMerchant(MerchantRequest request) {
        Merchant merchant= getMerchantFromDataBase(request.getId());
        userValidation(request.getUsername(),request.getPassword(),merchant.getUsername(),merchant.getPassword());
         merchant=requestToMerchant(request);
        if(request.getMaxAmountPerMonth()!=null)
            if(request.getMaxAmountPerMonth()<0)
                throw new BadRequestException("Invalid value for maximum amount per month: " + request.getMaxAmountPerMonth());
        if(request.getMaxAmountPerTransaction()!=null)
            if(request.getMaxAmountPerTransaction()<0)
                throw new BadRequestException("Invalid value for maximum amount per Transaction: " + request.getMaxAmountPerTransaction());
        if(request.getRole()!=null)
            validateRole(request.getRole());

        if(request.getDateOfBirth()!=null)
        {
            isValidDate(request.getDateOfBirth(),"yyyy-MM-dd");
        }
        merchantRepository.save(merchant);
        return new RegResponse("Success","Records updated successfully");
    }

    private void userValidation(String username, String password,String actualUserName,String actualPassword) {
        if(username==null || !username.equals(actualUserName))
            throw new BadRequestException("Wrong user name");
        if(password==null || !password.equals(actualPassword))
            throw new BadRequestException("wrong password");
    }

    @Override
    public RegResponse softDeleteMerchant(Long id) {
        Merchant merchant=getMerchantFromDataBase(id);
        merchant.setStatus("INACTIVE");
        merchantRepository.save(merchant);
        return new RegResponse("success"
                ,merchant.getBusinessShortName()+"  has been deleted successfully");
    }

        private void validateRequest(MerchantRequest request) {
        validateRole(request.getRole());
        nullConstraints(request);
        isValidDate(request.getDateOfBirth(),"yyyy-MM-dd");

    }
    public void isValidDate(String dateString, String dateFormat) {
        SimpleDateFormat sdf = new SimpleDateFormat(dateFormat);
        sdf.setLenient(false);

        try {
           sdf.parse(dateString);
        } catch (Exception e) {
            throw new BadRequestException("Not a valid date String");
        }
    }

    private void nullConstraints(MerchantRequest request) {
        if(StringUtils.isAnyBlank(request.getBusinessName(),
                request.getBusinessShortName(),
                request.getBusinessAddress1(),
                request.getCity(),
                request.getState(),
                request.getPostcode(),
                request.getBusinessContactNumber(),
                request.getFirstName(),
                request.getLastName(),
                request.getUsername(),
                request.getEmail(),
                request.getPassword(),
                request.getContactPersonName()))
        {
            throw new BadRequestException("Missing necessary fields: BusinessName, BusinessShortName, BusinessAddress1, City, State, Postcode, BusinessContactNumber, FirstName, LastName, Username, Email, Password, ContactPersonName");
        }
        if(request.getMaxAmountPerMonth()==null||request.getMaxAmountPerMonth()<0)
        {
            throw new BadRequestException("Invalid value for maximum amount per month: " + request.getMaxAmountPerMonth());
        }
        if(request.getMaxAmountPerTransaction()==null||request.getMaxAmountPerTransaction()<0)
        {
            throw new BadRequestException("Invalid value for maximum amount per transaction: " + request.getMaxAmountPerTransaction());
        }

    }

    private void validateRole(MerchantUserRole requiredRole)
    {
        boolean validRole=false;
        for(MerchantUserRole role : MerchantUserRole.values())
        {
            if(requiredRole.equals(role))
            {
                validRole=true;
                break;
            }
        }
        if(!validRole)
            throw new BadRequestException("invalid Role");
    }


    private Merchant getMerchantFromDataBase(Long id) {
        return merchantRepository.findById(id)
                .orElseThrow(() -> new BadRequestException("No merchant found with the provided id "));
    }
    private Merchant requestToMerchant(MerchantRequest request) {
        Merchant merchant=new Merchant();

        if (!StringUtils.isBlank(request.getBusinessAddress1())) {
            merchant.setBusinessAddress1(request.getBusinessAddress1());
        }
        if (!StringUtils.isBlank(request.getBusinessAddress2())) {
            merchant.setBusinessAddress2(request.getBusinessAddress2());
        }
        if (!StringUtils.isBlank(request.getBusinessAddress3())) {
            merchant.setBusinessAddress3(request.getBusinessAddress3());
        }
        if (!StringUtils.isBlank(request.getBusinessContactNumber())) {
            merchant.setBusinessContactNumber(request.getBusinessContactNumber());
        }
        if (!StringUtils.isBlank(request.getBusinessName())) {
            merchant.setBusinessName(request.getBusinessName());
        }
        if (!StringUtils.isBlank(request.getBusinessRegistrationNumber())) {
            merchant.setBusinessRegistrationNumber(request.getBusinessRegistrationNumber());
        }
        if (!StringUtils.isBlank(request.getBusinessShortName())) {
            merchant.setBusinessShortName(request.getBusinessShortName());
        }
        if (!StringUtils.isBlank(request.getBusinessType())) {
            merchant.setBusinessType(request.getBusinessType());
        }
        if (!StringUtils.isBlank(request.getCity())) {
            merchant.setCity(request.getCity());
        }
        if (!StringUtils.isBlank(request.getCompanyType())) {
            merchant.setCompanyType(request.getCompanyType());
        }
        if (!StringUtils.isBlank(request.getContactIc())) {
            merchant.setContactIc(request.getContactIc());
        }
        if (!StringUtils.isBlank(request.getContactPersonName())) {
            merchant.setContactPersonName(request.getContactPersonName());
        }
        if (!StringUtils.isBlank(request.getContactPersonPhoneNo())) {
            merchant.setContactPersonPhoneNo(request.getContactPersonPhoneNo());
        }
        if (!StringUtils.isBlank(request.getCountry())) {
            merchant.setCountry(request.getCountry());
        }
        if (!StringUtils.isBlank(request.getCurrency())) {
            merchant.setCurrency(request.getCurrency());
        }
        if (!StringUtils.isBlank(request.getDateOfBirth())) {
            merchant.setDateOfBirth(request.getDateOfBirth());
        }
        if (!StringUtils.isBlank(request.getDiscountAmount())) {
            merchant.setDiscountAmount(request.getDiscountAmount());
        }
        if (!StringUtils.isBlank(request.getEmail())) {
            merchant.setEmail(request.getEmail());
        }


        if (!StringUtils.isBlank(request.getEnableFraud())) {
            merchant.setEnableFraud(request.getEnableFraud());
        }

        merchant.setEnabled(true);
        if (!StringUtils.isBlank(request.getEnblPayout())) {
            merchant.setEnblPayout(request.getEnblPayout());
        }
        if (!StringUtils.isBlank(request.getEzyMotoVcc())) {
            merchant.setEzyMotoVcc(request.getEzyMotoVcc());
        }
        if (!StringUtils.isBlank(request.getFaxNo())) {
            merchant.setFaxNo(request.getFaxNo());
        }
        if (!StringUtils.isBlank(request.getFirstName())) {
            merchant.setFirstName(request.getFirstName());
        }
        if (!StringUtils.isBlank(request.getFraudClientId())) {
            merchant.setFraudClientId(request.getFraudClientId());
        }
        if (!StringUtils.isBlank(request.getIcPhotoPath())) {
            merchant.setIcPhotoPath(request.getIcPhotoPath());
        }
        if (!StringUtils.isBlank(request.getLastName())) {
            merchant.setLastName(request.getLastName());
        }
        if (!StringUtils.isBlank(request.getNatureOfBusiness())) {
            merchant.setNatureOfBusiness(request.getNatureOfBusiness());
        }
        if (!StringUtils.isBlank(request.getRemarks())) {
            merchant.setRemarks(request.getRemarks());
        }
        if (!StringUtils.isBlank(request.getSignedPackage())) {
            merchant.setSignedPackage(request.getSignedPackage());
        }
        if (!StringUtils.isBlank(request.getWebsite())) {
            merchant.setWebsite(request.getWebsite());
        }
        if (!StringUtils.isBlank(request.getSalutation())) {
            merchant.setSalutation(request.getSalutation());
        }
        if (!StringUtils.isBlank(request.getState())) {
            merchant.setState(request.getState());
        }
        if (!StringUtils.isBlank(request.getPostcode())) {
            merchant.setPostcode(request.getPostcode());
        }
        if (!StringUtils.isBlank(request.getUsername())) {
            merchant.setUsername(request.getUsername());
        }
        if (!StringUtils.isBlank(request.getPassword())) {
            merchant.setPassword(request.getPassword());
        }
        if (request.getMaxAmountPerTransaction()!=null) {
            merchant.setMaxAmountPerTransaction(request.getMaxAmountPerTransaction());
        }
        if (request.getMaxAmountPerMonth()!=null) {
            merchant.setMaxAmountPerMonth(request.getMaxAmountPerMonth());
        }
        if (!StringUtils.isBlank(request.getTradingName())) {
            merchant.setTradingName(request.getTradingName());
        }
        if (!StringUtils.isBlank(request.getOwnerName())) {
            merchant.setOwnerName(request.getOwnerName());
        }
        if (!StringUtils.isBlank(request.getOwnerPassportNo())) {
            merchant.setOwnerPassportNo(request.getOwnerPassportNo());
        }
        if (!StringUtils.isBlank(request.getOwnerContactNo())) {
            merchant.setOwnerContactNo(request.getOwnerContactNo());
        }
        if (!StringUtils.isBlank(request.getCompanyType())) {
            merchant.setCompanyType(request.getCompanyType());
        }
        if (!StringUtils.isBlank(request.getPermiseType())) {
            merchant.setPermiseType(request.getPermiseType());
        }
        if (!StringUtils.isBlank(request.getReaderSerialNo())) {
            merchant.setReaderSerialNo(request.getReaderSerialNo());
        }
        if (!StringUtils.isBlank(request.getReferralId())) {
            merchant.setReferralId(request.getReferralId());
        }
        if (!StringUtils.isBlank(request.getBankName())) {
            merchant.setBankName(request.getBankName());
        }
        if (!StringUtils.isBlank(request.getBankAcc())) {
            merchant.setBankAcc(request.getBankAcc());
        }
        if (!StringUtils.isBlank(request.getNricAcc())) {
            merchant.setNricAcc(request.getNricAcc());
        }
        if (!StringUtils.isBlank(request.getWaiverMonth())) {
            merchant.setWaiverMonth(request.getWaiverMonth());
        }
        if (request.getAgID()!=null) {
            merchant.setAgID(request.getAgID());
        }
        if (request.getSubAgID()!=null) {
            merchant.setSubAgID(request.getSubAgID());
        }
        if (!StringUtils.isBlank(request.getYearIncorporated())) {
            merchant.setYearIncorporated(request.getYearIncorporated());
        }
        if (!StringUtils.isBlank(request.getOwnerSalutation())) {
            merchant.setOwnerSalutation(request.getOwnerSalutation());
        }
        if (!StringUtils.isBlank(request.getResidentialAddress())) {
            merchant.setResidentialAddress(request.getResidentialAddress());
        }
        if (!StringUtils.isBlank(request.getMdr())) {
            merchant.setMdr(request.getMdr());
        }
        if (!StringUtils.isBlank(request.getPreAuth())) {
            merchant.setPreAuth(request.getPreAuth());
        }
        if (!StringUtils.isBlank(request.getAuth3DS())) {
            merchant.setAuth3DS(request.getAuth3DS());
        }
        if (!StringUtils.isBlank(request.getAllowRecurring())) {
            merchant.setAllowRecurring(request.getAllowRecurring());
        }
        if (!StringUtils.isBlank(request.getAutoSettled())) {
            merchant.setAutoSettled(request.getAutoSettled());
        }
        if (!StringUtils.isBlank(request.getLatitude())) {
            merchant.setLatitude(request.getLatitude());
        }
        if (!StringUtils.isBlank(request.getLongitude())) {
            merchant.setLongitude(request.getLongitude());
        }
        if (!StringUtils.isBlank(request.getIpAddress())) {
            merchant.setIpAddress(request.getIpAddress());
        }
        if (!StringUtils.isBlank(request.getMacAddress())) {
            merchant.setMacAddress(request.getMacAddress());
        }
        if (!StringUtils.isBlank(request.getMobiId())) {
            merchant.setMobiId(request.getMobiId());
        }
        if (!StringUtils.isBlank(request.getMerchantSector())) {
            merchant.setMerchantSector(request.getMerchantSector());
        }
        if (!StringUtils.isBlank(request.getMerchantCategory())) {
            merchant.setMerchantCategory(request.getMerchantCategory());
        }
        if (!StringUtils.isBlank(request.getISwitchEnable())) {
            merchant.setISwitchEnable(request.getISwitchEnable());
        }
        if (!StringUtils.isBlank(request.getJsCheckCount())) {
            merchant.setJsCheckCount(request.getJsCheckCount());
        }
        if (!StringUtils.isBlank(request.getJsWithdrawCount())) {
            merchant.setJsWithdrawCount(request.getJsWithdrawCount());
        }
        if (!StringUtils.isBlank(request.getISwitchDiscount())) {
            merchant.setISwitchDiscount(request.getISwitchDiscount());
        }
        if (!StringUtils.isBlank(request.getPaymentDate())) {
            merchant.setPaymentDate(request.getPaymentDate());
        }
        if (!StringUtils.isBlank(request.getReActivateDate())) {
            merchant.setReActivateDate(request.getReActivateDate());
        }
        if (!StringUtils.isBlank(request.getIsCombo())) {
            merchant.setIsCombo(request.getIsCombo());
        }
        if (!StringUtils.isBlank(request.getIsEzywirePlus())) {
            merchant.setIsEzywirePlus(request.getIsEzywirePlus());
        }

        if (!StringUtils.isBlank(request.getIntegrationPlatform())) {
            merchant.setIntegrationPlatform(request.getIntegrationPlatform());
        }
        if (!StringUtils.isBlank(request.getSettlementEmail())) {
            merchant.setSettlementEmail(request.getSettlementEmail());
        }

        merchant.setStatus("ACTIVE");
        if(request.getServiceNeeded()!=null) {
            if (
                    request.getServiceNeeded().isBoostNeeded() ||
                            request.getServiceNeeded().isGrabNeeded() ||
                            request.getServiceNeeded().isTngNeeded()
            )
                merchant.setEnableEwallet("Yes");
            if (request.getServiceNeeded().isFpxNeeded())
                merchant.setEnableFpx("yes");
            if (request.getServiceNeeded().isBnplNeeded())
                merchant.setEnableBnpl("yes");
            if (request.getServiceNeeded().isLocalCardNeeded())
                merchant.setEnableCard("yes");
            if (request.getServiceNeeded().isForeignCardNeeded())
                merchant.setForeignCard("yes");
        }

        return merchant;
    }
}
