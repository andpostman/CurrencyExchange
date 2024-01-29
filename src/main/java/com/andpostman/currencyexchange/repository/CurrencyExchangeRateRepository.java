package com.andpostman.currencyexchange.repository;

import com.andpostman.currencyexchange.model.ExchangeRate;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface CurrencyExchangeRateRepository extends JpaRepository<ExchangeRate, Long> {

    @Query(nativeQuery = true, value =
            "SELECT * FROM currency.exchange_rate " +
                    "WHERE base_currency = :base_currency " +
                    "AND target_currency = :target_currency "+
                    "AND purchase_rate = (SELECT MIN(purchase_rate) FROM currency.exchange_rate)")
    Optional<ExchangeRate> findMinPurchaseRateByXcodeCur(@Param("base_currency") String baseCurrency, @Param("target_currency") String targetCurrency);

    @Query(nativeQuery = true, value =
            "SELECT * FROM currency.exchange_rate " +
                    "WHERE base_currency = :base_currency " +
                    "AND target_currency = :target_currency "+
                    "AND sale_rate = (SELECT MIN(sale_rate) FROM currency.exchange_rate)")
    Optional<ExchangeRate> findMinSaleRateByXcodeCur(@Param("base_currency") String baseCurrency, @Param("target_currency") String targetCurrency);
}
