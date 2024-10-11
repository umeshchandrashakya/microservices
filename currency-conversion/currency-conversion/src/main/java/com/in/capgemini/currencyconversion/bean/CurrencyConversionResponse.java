package com.in.capgemini.currencyconversion.bean;

import java.math.BigDecimal;

public class CurrencyConversionResponse {
    private Long id;
    private String from;
    private String to;

    private BigDecimal quantity;
    private BigDecimal conversionMultiple;
    private BigDecimal totalCalculationAmount;

    public CurrencyConversionResponse(Long id, String from, String to, BigDecimal quantity, BigDecimal conversionMultiple, BigDecimal totalCalculationAmount) {
        this.id = id;
        this.from = from;
        this.to = to;
        this.quantity = quantity;
        this.conversionMultiple = conversionMultiple;
        this.totalCalculationAmount = totalCalculationAmount;

    }

    private String environment;

    public String getEnvironment() {
        return environment;
    }

    public void setEnvironment(String environment) {
        this.environment = environment;
    }



    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFrom() {
        return from;
    }

    public void setFrom(String from) {
        this.from = from;
    }

    public String getTo() {
        return to;
    }

    public void setTo(String to) {
        this.to = to;
    }

    public BigDecimal getConversionMultiple() {
        return conversionMultiple;
    }

    public void setConversionMultiple(BigDecimal conversionMultiple) {
        this.conversionMultiple = conversionMultiple;
    }

    public BigDecimal getQuantity() {
        return quantity;
    }

    public void setQuantity(BigDecimal quantity) {
        this.quantity = quantity;
    }

    public BigDecimal getTotalCalculationAmount() {
        return totalCalculationAmount;
    }

    public void setTotalCalculationAmount(BigDecimal totalCalculationAmount) {
        this.totalCalculationAmount = totalCalculationAmount;
    }


}
