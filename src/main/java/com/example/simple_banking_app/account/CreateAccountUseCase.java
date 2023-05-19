package com.example.simple_banking_app.account;

import com.example.simple_banking_app.account.api.dto.CreateAccount;
import com.example.simple_banking_app.account.api.dto.CurrencyType;
import jakarta.transaction.Transactional;


@Transactional
class CreateAccountUseCase {
    private final AccountRepository accountRepository;

    CreateAccountUseCase(AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }

    public void execute(CreateAccount createAccount) {
        var accountToSave = new AccountEntity();
        accountToSave.setUserPesel(createAccount.pesel());
        accountToSave.createCurrencyAccountForCurrency(CurrencyType.PLN, createAccount.statingAmountOfMoney());
        accountToSave.createCurrencyAccountForCurrency(CurrencyType.USD, 0);
        accountRepository.save(accountToSave);
    }


}
