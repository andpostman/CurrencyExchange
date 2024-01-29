package com.andpostman.currencyexchange.service;

import com.andpostman.currencyexchange.exception.NotFoundExchangeRateException;
import com.andpostman.currencyexchange.model.ExchangeOffice;
import com.andpostman.currencyexchange.property.BestExchangeRate;
import com.andpostman.currencyexchange.property.BestPurchaseRate;
import com.andpostman.currencyexchange.property.BestSaleRate;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import com.andpostman.currencyexchange.model.ExchangeRate;
import com.andpostman.currencyexchange.repository.CurrencyExchangeOfficeRepository;
import com.andpostman.currencyexchange.repository.CurrencyExchangeRateRepository;

@Service
@RequiredArgsConstructor
@Slf4j
public class CurrencyServiceImpl implements CurrencyService{

    private final CurrencyExchangeOfficeRepository exchangeOfficeRepository;
    private final CurrencyExchangeRateRepository exchangeRateRepository;

    @Override
    public BestExchangeRate exchange(BestExchangeRate exchangeRate) {
        ExchangeRate exchangePurchaseRates = exchangeRateRepository
                .findMinPurchaseRateByXcodeCur(exchangeRate.getBaseCurrency(), exchangeRate.getTargetCurrency())
                .orElseThrow(NotFoundExchangeRateException::new);
        ExchangeRate exchangeSaleRates = exchangeRateRepository
                .findMinSaleRateByXcodeCur(exchangeRate.getBaseCurrency(), exchangeRate.getTargetCurrency())
                .orElseThrow(NotFoundExchangeRateException::new);

        ExchangeOffice purchaseRatesExchangeOffice = exchangePurchaseRates.getExchangeOffice();
        ExchangeOffice saleRatesExchangeOffice = exchangeSaleRates.getExchangeOffice();
        exchangeRate.setBestPurchaseRate(new BestPurchaseRate(purchaseRatesExchangeOffice.getBankName(), purchaseRatesExchangeOffice.getAddress(), exchangePurchaseRates.getPurchaseRate(),exchangePurchaseRates.getSaleRate()));
        exchangeRate.setBestSaleRate(new BestSaleRate(saleRatesExchangeOffice.getBankName(), saleRatesExchangeOffice.getAddress(),exchangeSaleRates.getPurchaseRate(),exchangeSaleRates.getSaleRate()));
        log.info("result: {}",exchangeRate);
        return exchangeRate;
    }
}
