package com.in.capgemini.currencyconversion.feign;

import com.in.capgemini.currencyconversion.bean.CurrencyConversionResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import java.math.BigDecimal;

@FeignClient(name="currency-exchange",url = "localhost:8000")
public interface CurrencyConversionProxy {
    @GetMapping("/currency-exchange/from/{from}/to/{to}")
    public CurrencyConversionResponse convertCurrencyProxy(
            @RequestParam String from,
            @RequestParam String to,
            @RequestParam BigDecimal quantity) ;
}
