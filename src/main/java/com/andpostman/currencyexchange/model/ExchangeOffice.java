package com.andpostman.currencyexchange.model;

import jakarta.persistence.*;
import lombok.*;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

@Entity
@Table(name = "exchange_office", schema = "currency", indexes = @Index(name = "exchange_office_id_idx",columnList = "id"))
@Getter
@NoArgsConstructor
@RequiredArgsConstructor
@EqualsAndHashCode(exclude = "id")
public class ExchangeOffice {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(name = "bank_name")
    private @NonNull String bankName;
    @Column(name = "address")
    private @NonNull String address;

    @Override
    public String toString() {
        return new ToStringBuilder(this, ToStringStyle.MULTI_LINE_STYLE)
                .append("name", bankName)
                .append("address",address)
                .toString();
    }
}
