package com.andpostman.currencyexchange.controller;

import com.andpostman.currencyexchange.property.BestExchangeRate;
import com.andpostman.currencyexchange.service.CurrencyServiceImpl;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@Slf4j
public class CurrencyController {

    private final CurrencyServiceImpl service;

    @PostMapping("/exchange")
    public BestExchangeRate exchangeCurrencyRate(@RequestBody BestExchangeRate exchangeRate){
        log.info("get exchangeRate: {}", exchangeRate);
        return service.exchange(exchangeRate);
    }
}
