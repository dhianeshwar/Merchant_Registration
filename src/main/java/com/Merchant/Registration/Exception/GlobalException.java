package com.Merchant.Registration.Exception;

import com.Merchant.Registration.Response.RegResponse;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalException {
    @ExceptionHandler(value={BadRequestException.class})
    public ResponseEntity<RegResponse> badRequestExceptionResponseEntity(Exception exception, HttpServletRequest request)
    {
        return new ResponseEntity<>(new RegResponse("failed", exception.getMessage()), HttpStatus.BAD_REQUEST);
    }

}
