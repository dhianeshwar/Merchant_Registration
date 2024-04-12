package com.Merchant.Registration.Response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.springframework.web.bind.annotation.GetMapping;

@Getter
@Setter
@AllArgsConstructor

public class RegResponse {
    private String response;
    private String responseMessage;
}
