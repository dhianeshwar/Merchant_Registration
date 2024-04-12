package com.Merchant.Registration.serviceimpl;

import com.Merchant.Registration.Exception.BadRequestException;
import com.Merchant.Registration.Service.MerchantService;
import com.Merchant.Registration.ServiceImpl.MerchantServiceImpl;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;


public class MerchantServiceImplTest {

    @Test
        public void testValidDate() {
            MerchantService merchantService=new MerchantServiceImpl();
        // Arrange
        String validDateString = "2024-03-19";
        String dateFormat = "yyyy-MM-dd";
        assertDoesNotThrow(() -> merchantService.isValidDate(validDateString, dateFormat));
    }
    @Test
    public void testInvalidDate() {
        MerchantService merchantService=new MerchantServiceImpl();
        String invalidDateString = "20-02-30"; // Invalid date feb 30
        assertThrows(BadRequestException.class, () -> merchantService.isValidDate(invalidDateString, "yyyy-MM-dd"));
    }

}
