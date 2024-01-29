package com.andpostman.currencyexchange.repository;

import com.andpostman.currencyexchange.model.ExchangeOffice;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CurrencyExchangeOfficeRepository extends JpaRepository<ExchangeOffice, Long> {
}
