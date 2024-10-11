package com.capgemini.microservices.limitsservice.controller;

import com.capgemini.microservices.limitsservice.bean.Limits;
import com.capgemini.microservices.limitsservice.configuration.Configuration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LimitController {

    @Autowired
    private Configuration configuration;
int i =20;

    @GetMapping("/limits")
    public Limits retriveLimits(){
    return new Limits(configuration.getMinimum(),configuration.getMaximum());
    }
}
