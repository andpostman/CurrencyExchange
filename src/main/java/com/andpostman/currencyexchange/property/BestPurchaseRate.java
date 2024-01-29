package com.andpostman.currencyexchange.property;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonRootName;
import lombok.AllArgsConstructor;
import lombok.Data;
import java.io.Serializable;
import java.math.BigDecimal;

@Data
@AllArgsConstructor
@JsonRootName("best_purchase_rates")
public class BestPurchaseRate implements Serializable {
    @JsonProperty("bank_name")
    String bankName;
    @JsonProperty("address")
    String address;
    @JsonProperty("buy_rate")
    BigDecimal bayRate;
    @JsonProperty("sell_rate")
    BigDecimal sellRate;
}
