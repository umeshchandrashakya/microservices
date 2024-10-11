package com.capgemini.microservice.controller;

import com.capgemini.microservice.beans.CurrencyExchange;
import com.capgemini.microservice.entity.CurrencyExchangeEntity;
import com.capgemini.microservice.repository.CurrencyExchangeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;

@RestController
public class CurrencyExchangeController {

    @Autowired
    private Environment environment;

    @Autowired
    CurrencyExchangeRepository currencyExchangeRepository;

    @GetMapping("/currency-exchange/from/{from}/to/{to}")
    public CurrencyExchangeEntity retrieveExchangeValue(@PathVariable String from,
                                                  @PathVariable String to){
        CurrencyExchangeEntity byFromAndTo = currencyExchangeRepository.findByFromAndTo(from, to);
        byFromAndTo.setEnvironment(environment.getProperty("local.server.port"));
        return byFromAndTo;
    }
}
