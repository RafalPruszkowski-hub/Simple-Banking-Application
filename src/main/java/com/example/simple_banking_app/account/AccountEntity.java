package com.example.simple_banking_app.account;

import com.example.simple_banking_app.account.api.dto.CurrencyType;
import com.example.simple_banking_app.account.api.exceptions.CurrencyAccountNotFound;
import jakarta.persistence.*;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Entity
@Getter
@Setter
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
class AccountEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @EqualsAndHashCode.Include
    private UUID id;
    private UUID userId;
    @OneToMany(mappedBy = "account", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<CurrencyAccountEntity> currencyAccounts = new ArrayList<>();

    void createCurrencyAccountForCurrency(CurrencyType currencyType, double amount) {
        var currencyAccountEntity = new CurrencyAccountEntity();
        currencyAccountEntity.setAccount(this);
        currencyAccountEntity.setCurrencyType(currencyType);
        currencyAccountEntity.setAmount(amount);
        this.currencyAccounts.add(currencyAccountEntity);
    }

    void exchangeCurrency(CurrencyType from, CurrencyType to, double amount, double exchangeRate) {
        var fromAccount = getCurrencyTypeAccount(from);
        var toAccount = getCurrencyTypeAccount(to);
        fromAccount.setAmount(fromAccount.getAmount() - amount);
        toAccount.setAmount(toAccount.getAmount() + (amount * exchangeRate));
    }

    CurrencyAccountEntity getCurrencyTypeAccount(CurrencyType currencyType) {
        return currencyAccounts.stream()
                .filter(accountCurrency -> accountCurrency.getCurrencyType() == currencyType)
                .findFirst()
                .orElseThrow(() -> new CurrencyAccountNotFound(String.format("Currency account for currency type %s", currencyType)));
    }
}
