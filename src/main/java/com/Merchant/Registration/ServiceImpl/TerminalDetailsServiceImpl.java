package com.Merchant.Registration.ServiceImpl;

import com.Merchant.Registration.Exception.BadRequestException;
import com.Merchant.Registration.Repository.InternalTableRepository;
import com.Merchant.Registration.Repository.TerminalDetailsRepository;
import com.Merchant.Registration.Service.TerminalDetailsService;
import com.Merchant.Registration.entity.*;
import com.Merchant.Registration.request.ServiceNeeded;
import org.springframework.stereotype.Service;

import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class TerminalDetailsServiceImpl implements TerminalDetailsService {
    private final TerminalDetailsRepository terminalDetailsRepository;
    private final InternalTableRepository internalTableRepository;

    public TerminalDetailsServiceImpl(TerminalDetailsRepository terminalDetailsRepository,InternalTableRepository internalTableRepository)
    {
        this.terminalDetailsRepository=terminalDetailsRepository;
        this.internalTableRepository=internalTableRepository;
    }
    public Map<String, String> addTerminalDetails(ServiceNeeded request, MID mid, MobileUser mobileUser, Merchant merchant)
    {
        try {
            Map<String,String> values=new HashMap<>();
            List<TerminalDetails> terminalDetailsList=new ArrayList<>();
            List<InternalTable> internalTableList=new ArrayList<>();
            System.out.println(request);
            String stan = internalTableRepository.getStanByTid("MOTO_DEVICEID");
            System.out.println("STAN value --->"+stan);
            int count = 0;

            values.put("Merchant Id",String.valueOf(merchant.getId()));
            values.put("MID ID",String.valueOf(mid.getId()));
            values.put("Mobile User Id",String.valueOf(mobileUser.getId()));
            values.put("MOTO API KEY",mobileUser.getMotoApiKey());


            if (request.isEzyMotoNeeded()) {
                count++;
                TerminalDetails terminalDetails = new TerminalDetails();
                terminalDetails.setDeviceId("MOTO" + (Long.parseLong(stan) + count));
                terminalDetails.setDeviceType("EZYMOTO");
                terminalDetails.setMerchantId(mid.getUmMotoMid());
                terminalDetails.setActiveStatus("ACTIVE");
                terminalDetails.setTid(mobileUser.getMotoTid());
                terminalDetails.setActivationCode(generateActivationCode("MOTO"));
                terminalDetails.setContactName(merchant.getContactPersonName());
                terminalDetails.setConnectType("BT");

                InternalTable internalTable=new InternalTable(
                        mobileUser.getMotoTid(),
                        1L,
                        1L,
                        mid.getUmMotoMid(),
                        1L
                );
                terminalDetailsList.add(terminalDetails);
                internalTableList.add(internalTable);
                values.put("MOTO TID",mobileUser.getMotoTid());
                values.put("UM MOTO MID",mid.getUmMotoMid());
            }
            if (request.isEzyWayNeeded()) {
                count++;
                TerminalDetails terminalDetails = new TerminalDetails();
                terminalDetails.setDeviceId("EZYWAY" + String.valueOf(Long.parseLong(stan) + count));
                terminalDetails.setDeviceType("EZYWAY");
                terminalDetails.setMerchantId(mid.getUmEzywayMid());
                terminalDetails.setActiveStatus("ACTIVE");
                terminalDetails.setTid(mobileUser.getEzywayTid());
                terminalDetails.setActivationCode(generateActivationCode("EZYWAY"));
                terminalDetails.setContactName(merchant.getContactPersonName());
                terminalDetails.setConnectType("WEB");

                InternalTable internalTable=new InternalTable(
                        mobileUser.getEzywayTid(),
                        1L,
                        1L,
                        mid.getUmEzywayMid(),
                        1L
                );
                terminalDetailsList.add(terminalDetails);
                internalTableList.add(internalTable);
                values.put("EZYWAY TID",mobileUser.getEzywayTid());
                values.put("UM EZYWAY MID",mid.getUmEzywayMid());
            }

            if (request.isBoostNeeded()) {
                count++;
                TerminalDetails terminalDetails = new TerminalDetails();
                terminalDetails.setDeviceId("BOOST" + String.valueOf(Long.parseLong(stan) + count));
                terminalDetails.setDeviceType("BOOST");
                terminalDetails.setMerchantId(mid.getBoostMid());
                terminalDetails.setActiveStatus("ACTIVE");
                terminalDetails.setTid(mobileUser.getBoostTid());
                terminalDetails.setActivationCode(generateActivationCode("BOOST"));
                terminalDetails.setContactName(merchant.getContactPersonName());
                terminalDetails.setConnectType("BT");

                InternalTable internalTable=new InternalTable(
                        mobileUser.getBoostTid(),
                        1L,
                        1L,
                        mid.getBoostMid(),
                        1L
                );
                terminalDetailsList.add(terminalDetails);
                internalTableList.add(internalTable);
                values.put("BOOST TID",mobileUser.getBoostTid());
                values.put("BOOST MID",mid.getBoostMid());
            }
            if (request.isGrabNeeded()) {
                count++;
                TerminalDetails terminalDetails = new TerminalDetails();
                terminalDetails.setDeviceId("GRAB" + String.valueOf(Long.parseLong(stan) + count));
                terminalDetails.setDeviceType("GRAB");
                terminalDetails.setMerchantId(mid.getGrabMid());
                terminalDetails.setActiveStatus("ACTIVE");
                terminalDetails.setTid(mobileUser.getGpayTid());
                terminalDetails.setActivationCode(generateActivationCode("GRAB"));
                terminalDetails.setContactName(merchant.getContactPersonName());
                terminalDetails.setConnectType("BT");

                InternalTable internalTable=new InternalTable(
                        mobileUser.getGpayTid(),
                        1L,
                        1L,
                        mid.getGrabMid(),
                        1L
                );
                terminalDetailsList.add(terminalDetails);
                internalTableList.add(internalTable);

                values.put("GRAB TID",mobileUser.getGpayTid());
                values.put("GRAB MID",mid.getGrabMid());

            }

            if (request.isTngNeeded()) {
                count++;
                TerminalDetails terminalDetails = new TerminalDetails();
                terminalDetails.setDeviceId("TNG" + String.valueOf(Long.parseLong(stan) + count));
                terminalDetails.setDeviceType("TNG");
                terminalDetails.setMerchantId(mid.getTngMid());
                terminalDetails.setActiveStatus("ACTIVE");
                terminalDetails.setTid(mobileUser.getTngTid());
                terminalDetails.setActivationCode(generateActivationCode("TNG"));
                terminalDetails.setContactName(merchant.getContactPersonName());
                terminalDetails.setConnectType("BT");

                InternalTable internalTable=new InternalTable(
                        mobileUser.getTngTid(),
                        1L,
                        1L,
                        mid.getTngMid(),
                        1L
                );
                terminalDetailsList.add(terminalDetails);
                internalTableList.add(internalTable);

                values.put("TNG TID",mobileUser.getTngTid());
                values.put("TNG MID",mid.getTngMid());
            }
            if (request.isBnplNeeded()) {
                count++;
                TerminalDetails terminalDetails = new TerminalDetails();
                terminalDetails.setDeviceId("BNPL" + String.valueOf(Long.parseLong(stan) + count));
                terminalDetails.setDeviceType("BNPL");
                terminalDetails.setMerchantId(mid.getBnplMid());
                terminalDetails.setActiveStatus("ACTIVE");
                terminalDetails.setTid(mobileUser.getBnplTid());
                terminalDetails.setActivationCode(generateActivationCode("BNPL"));
                terminalDetails.setContactName(merchant.getContactPersonName());
                terminalDetails.setConnectType("BT");

                InternalTable internalTable=new InternalTable(
                        mobileUser.getBnplTid(),
                        1L,
                        1L,
                        mid.getBnplMid(),
                        1L
                );
                terminalDetailsList.add(terminalDetails);
                internalTableList.add(internalTable);

                values.put("BNPL TID",mobileUser.getBnplTid());
                values.put("BNPL MID",mid.getBnplMid());
            }
            internalTableRepository.saveAll(internalTableList);
            terminalDetailsRepository.saveAll(terminalDetailsList);
            System.out.println("COUNT FOR THE SERVICES --->"+count);
            String updatedStanValue= String.valueOf(Long.parseLong(stan) + count);
            System.out.println("The New Stan value for MOTO-DEVICE-ID is--->"+updatedStanValue);
            internalTableRepository.updateStan(updatedStanValue);

            return values;

        }catch(NumberFormatException e)
        {
            throw new BadRequestException("STAN VALUES PARSING ERROR");
        }
        catch (Exception e)
        {
            throw new BadRequestException("Exception while inserting Terminal Details ");
        }


    }
    private String generateActivationCode(String productType)
    {
        SecureRandom secureRandom=new SecureRandom();
        String front=String.valueOf(secureRandom.nextInt(9999));
        String back=String.valueOf(secureRandom.nextInt(9999));
        System.out.println("ACTIVATION CODE FOR " +productType+" TERMINAL DETAILS  " +front+productType+back);
        return front+productType+back;
    }
}
