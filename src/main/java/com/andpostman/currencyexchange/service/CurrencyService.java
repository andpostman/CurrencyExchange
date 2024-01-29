package com.andpostman.currencyexchange.service;

import com.andpostman.currencyexchange.property.BestExchangeRate;

public interface CurrencyService {
    BestExchangeRate exchange(BestExchangeRate exchangeRate);
}
