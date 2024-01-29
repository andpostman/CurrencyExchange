package com.andpostman.currencyexchange.property;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class BestExchangeRate {
    @JsonProperty("base_currency")
    String baseCurrency;
    @JsonProperty("target_currency")
    String targetCurrency;
    @JsonProperty("best_purchase_rates")
    BestPurchaseRate bestPurchaseRate;
    @JsonProperty("best_sale_rates")
    BestSaleRate bestSaleRate;

    public BestExchangeRate(String baseCurrency, String targetCurrency) {
        this.baseCurrency = baseCurrency;
        this.targetCurrency = targetCurrency;
    }

}
