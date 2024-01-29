package com.andpostman.currencyexchange.exception;

public class NotFoundExchangeRateException extends RuntimeException {
    public NotFoundExchangeRateException() {
        super("The exchange rate was not found");
    }
}
