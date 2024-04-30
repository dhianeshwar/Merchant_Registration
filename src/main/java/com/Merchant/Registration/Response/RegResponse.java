package com.Merchant.Registration.Response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.Map;

@Getter
@Setter
@AllArgsConstructor

public class RegResponse {
    private String response;
    private String responseMessage;
    private Map<String,String> values;

    public RegResponse(String response,String responseMessage)
    {
        this.response=response;
        this.responseMessage=responseMessage;
    }
}
