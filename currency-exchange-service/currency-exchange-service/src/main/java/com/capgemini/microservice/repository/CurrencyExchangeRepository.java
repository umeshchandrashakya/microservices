package com.capgemini.microservice.repository;

import com.capgemini.microservice.beans.CurrencyExchange;
import com.capgemini.microservice.entity.CurrencyExchangeEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CurrencyExchangeRepository extends JpaRepository<CurrencyExchangeEntity,Long> {
    CurrencyExchangeEntity findByFromAndTo(String from, String to);

}
