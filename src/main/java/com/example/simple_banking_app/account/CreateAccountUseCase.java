package com.example.simple_banking_app.account;

import com.example.simple_banking_app.account.api.dto.Account;
import com.example.simple_banking_app.account.api.dto.CreateAccount;
import com.example.simple_banking_app.account.api.dto.CurrencyType;
import jakarta.transaction.Transactional;

import java.util.ArrayList;
import java.util.List;

class CreateAccountUseCase {
    private final AccountRepository accountRepository;

    CreateAccountUseCase(AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }

    @Transactional
    public void execute(CreateAccount createAccount) {
        var accountToSave = AccountEntity.builder()
                .userId(createAccount.userId())
                .currencyAccounts(new ArrayList<>())
                .build();
        accountToSave.createCurrencyAccountForCurrency(CurrencyType.PLN, createAccount.statingAmountOfMoney());
        accountToSave.createCurrencyAccountForCurrency(CurrencyType.USD, 0);
        accountRepository.save(accountToSave);
    }


}
