package com.Merchant.Registration.controller;

import com.Merchant.Registration.Response.RegResponse;
import com.Merchant.Registration.Service.MerchantService;
import com.Merchant.Registration.entity.Merchant;
import com.Merchant.Registration.request.MerchantRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/reg")
public class MerchantRegistrationController {
    @Autowired
    private MerchantService merchantService;

    public MerchantRegistrationController(MerchantService merchantService) {
        this.merchantService = merchantService;
    }

    @GetMapping("/getMerchantBusinessShortName")
    public String getMerchantBusinessShortName(@RequestParam("id")Long id)
    {
        return merchantService.getMerchantBusinessShortNameByID(id);
    }

    @GetMapping("/getMerchant")
    public Merchant getMerchant(@RequestParam("id")Long id)
    {
        return merchantService.getMerchantByID(id);
    }

    @PostMapping("/newMerchant")
    public RegResponse newMerchant(@RequestBody MerchantRequest request)
    {
        return merchantService.addNewMerchant(request);
    }
    @PostMapping("/updateMerchant")
    public RegResponse updateMerchant(@RequestBody MerchantRequest request)
    {
        return merchantService.updateExistingMerchant(request);
    }

    @PostMapping("/deleteMerchant")
    public RegResponse deleteMerchant(@RequestParam("id")Long id)
    {
        return merchantService.softDeleteMerchant(id);
    }

}
