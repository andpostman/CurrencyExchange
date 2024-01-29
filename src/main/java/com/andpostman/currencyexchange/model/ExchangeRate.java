package com.andpostman.currencyexchange.model;

import jakarta.persistence.*;
import lombok.*;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Table(name = "exchange_rate", schema = "currency", indexes = @Index(name = "exchange_rate_id_idx", columnList = "id"))
@Getter
@NoArgsConstructor
@RequiredArgsConstructor
@EqualsAndHashCode(exclude = "id")
public class ExchangeRate {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(name = "base_currency")
    private @NonNull String baseCurrency;
    @Column(name = "target_currency")
    private @NonNull String targetCurrency;
    @Column(name = "date")
    private @NonNull LocalDateTime date;
    @Column(name = "purchase_rate")
    private @NonNull BigDecimal purchaseRate;
    @Column(name = "sale_rate")
    private @NonNull BigDecimal saleRate;
    @ManyToOne
    @JoinColumn(name = "exchange_office_id")
    private @NonNull ExchangeOffice exchangeOffice;

    @Override
    public String toString() {
        return new ToStringBuilder(this, ToStringStyle.MULTI_LINE_STYLE)
                .append("base_currency", baseCurrency)
                .append("target_currency", targetCurrency)
                .append("date",date)
                .append("purchaseRate",purchaseRate)
                .append("saleRate",saleRate)
                .append("exchangeOffice",exchangeOffice)
                .toString();
    }
}
