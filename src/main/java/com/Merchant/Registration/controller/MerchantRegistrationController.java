package com.Merchant.Registration.controller;

import com.Merchant.Registration.Exception.BadRequestException;
import com.Merchant.Registration.Response.RegResponse;
import com.Merchant.Registration.Service.MerchantService;
import com.Merchant.Registration.entity.Merchant;
import com.Merchant.Registration.request.MerchantRequest;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;



@RestController
@RequestMapping("/reg")
@Validated
public class MerchantRegistrationController {
    @Autowired
    private final MerchantService merchantService;

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
    public RegResponse newMerchant(@Valid @RequestBody MerchantRequest request)
    {
        return  merchantService.addNewMerchant(request);
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
