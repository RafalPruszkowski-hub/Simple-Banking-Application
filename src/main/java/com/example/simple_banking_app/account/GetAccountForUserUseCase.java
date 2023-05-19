package com.example.simple_banking_app.account;

import com.example.simple_banking_app.account.api.dto.Account;
import com.example.simple_banking_app.account.api.dto.AccountBuilder;
import com.example.simple_banking_app.account.api.dto.CurrencyAccount;
import com.example.simple_banking_app.account.api.dto.CurrencyAccountBuilder;

import java.util.UUID;

class GetAccountForUserUseCase {

    private final AccountRepository accountRepository;


    GetAccountForUserUseCase(AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }

    public Account execute(UUID userId) {
        return map(accountRepository.getByUserId(userId));
    }

    private Account map(AccountEntity accountEntity) {
        var currencyAccounts = accountEntity.getCurrencyAccounts()
                .stream()
                .map(this::map)
                .toList();
        return AccountBuilder.builder()
                .currencyAccounts(currencyAccounts)
                .build();
    }

    private CurrencyAccount map(CurrencyAccountEntity currencyAccountEntity) {
        return CurrencyAccountBuilder.builder()
                .currencyType(currencyAccountEntity.getCurrencyType())
                .amount(currencyAccountEntity.getAmount())
                .build();
    }
}
