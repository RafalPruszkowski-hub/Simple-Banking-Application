package com.example.simple_banking_app.account;

import com.example.simple_banking_app.account.api.dto.Account;
import com.example.simple_banking_app.account.api.dto.AccountBuilder;
import com.example.simple_banking_app.account.api.dto.CurrencyAccount;
import com.example.simple_banking_app.account.api.dto.CurrencyAccountBuilder;

class GetAccountForUserPeselUseCase {

    private final AccountRepository accountRepository;


    GetAccountForUserPeselUseCase(AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }

    Account execute(String userPesel) {
        return map(accountRepository.getByUserPesel(userPesel));
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
