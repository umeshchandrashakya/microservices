package com.capgemini.microservice;

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import io.github.resilience4j.retry.annotation.Retry;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;



@RestController
public class CircuitBreakerController {

private Logger logger = LoggerFactory.getLogger(CircuitBreakerController.class);
    @GetMapping("/sample-api")
   // @Retry(name = "sample-api",fallbackMethod = "fallbackResponse")
    // now play with circuit Breaker
    @CircuitBreaker(name= "default" ,fallbackMethod = "fallbackResponse")
    public String sampleApi() {
        logger.info("sample Api call received");
        ResponseEntity<String> forEntity = new RestTemplate().getForEntity("http://8080/some-dummy-url", String.class);
        forEntity.getBody();
        return forEntity.getBody();
    }

    public String fallbackResponse(Exception e){
        return "fallback response";
    }
}
