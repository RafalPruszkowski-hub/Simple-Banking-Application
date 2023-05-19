package com.example.simple_banking_app.account;

import com.example.simple_banking_app.account.api.dto.CurrencyType;
import jakarta.persistence.*;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import java.util.List;
import java.util.UUID;

@Entity
@Getter
@Setter
@Builder
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
class AccountEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @EqualsAndHashCode.Include
    private UUID id;
    private UUID userId;
    @OneToMany(mappedBy = "account")
    private List<CurrencyAccountEntity> currencyAccounts;


    void createCurrencyAccountForCurrency(CurrencyType currencyType, double amount) {
        var currencyAccountEntity = CurrencyAccountEntity.builder()
                .account(this)
                .currencyType(currencyType)
                .amount(amount)
                .build();
        this.currencyAccounts.add(currencyAccountEntity);
    }
}
