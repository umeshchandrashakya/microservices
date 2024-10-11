package com.in.capgemini.currencyconversion.controller;

import com.in.capgemini.currencyconversion.bean.CurrencyConversionResponse;
import com.in.capgemini.currencyconversion.feign.CurrencyConversionProxy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.math.BigDecimal;
import java.util.HashMap;

@RestController
public class CurrencyConversionController {

    @Autowired
    Environment environment;

    @Autowired
    CurrencyConversionProxy proxy;

    @GetMapping("/currency-conversion/from/{from}/to/{to}/quantity/{quantity}")
    public CurrencyConversionResponse convertCurrency(
            @PathVariable String from,
            @PathVariable String to,
            @PathVariable BigDecimal quantity) {
        HashMap<String,String>uriVariables = new HashMap<>();
        uriVariables.put("from",from);
        uriVariables.put("to",to);
        ResponseEntity<CurrencyConversionResponse> forEntity = new RestTemplate().getForEntity("http://localhost:8000/currency-exchange/from/USD/to/INR", CurrencyConversionResponse.class, uriVariables);
        CurrencyConversionResponse body = forEntity.getBody();
        CurrencyConversionResponse currencyConversionResponse = new CurrencyConversionResponse(
                body.getId(),
                from,
                to,
                quantity,
                body.getConversionMultiple(),
                quantity.multiply(body.getConversionMultiple()));
        currencyConversionResponse.setEnvironment(environment.getProperty("server.port")+"rest template");
        return currencyConversionResponse;
    }


    @GetMapping("/currency-conversion-feign/from/{from}/to/{to}/quantity/{quantity}")
    public CurrencyConversionResponse convertCurrencyProxy(
            @PathVariable String from,
            @PathVariable String to,
            @PathVariable BigDecimal quantity) {
        CurrencyConversionResponse response = proxy.convertCurrencyProxy(from,to,quantity);
        CurrencyConversionResponse currencyConversionResponse = new CurrencyConversionResponse(response.getId(),
                from, to, quantity,
                response.getConversionMultiple(),
                quantity.multiply(response.getConversionMultiple()));
        currencyConversionResponse.setEnvironment(environment.getProperty("server.port")+"feign");
        return currencyConversionResponse;
    }
}
