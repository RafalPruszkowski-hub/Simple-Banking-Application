package com.example.simple_banking_app.account;

import com.example.simple_banking_app.account.api.AccountFacade;
import com.example.simple_banking_app.account.api.dto.Account;
import com.example.simple_banking_app.account.api.dto.CreateAccount;
import com.example.simple_banking_app.account.api.dto.ExchangeCurrency;

import java.util.UUID;

class AccountFacadeImpl implements AccountFacade {
    private final CreateAccountUseCase createAccountUseCase;
    private final GetAccountForUserUseCase getAccountForUserUseCase;
    private final ExchangeCurrencyUseCase exchangeCurrencyUseCase;

    AccountFacadeImpl(CreateAccountUseCase createAccountUseCase, GetAccountForUserUseCase getAccountForUserUseCase, ExchangeCurrencyUseCase exchangeCurrencyUseCase) {
        this.createAccountUseCase = createAccountUseCase;
        this.getAccountForUserUseCase = getAccountForUserUseCase;
        this.exchangeCurrencyUseCase = exchangeCurrencyUseCase;
    }

    @Override
    public Account getAccountsForUserId(UUID userId) {
        return getAccountForUserUseCase.execute(userId);
    }

    @Override
    public void createAccountsForUserId(CreateAccount createAccount) {
        createAccountUseCase.execute(createAccount);
    }

    @Override
    public void exchangeCurrency(ExchangeCurrency exchangeCurrency, UUID userId) {
        exchangeCurrencyUseCase.execute(exchangeCurrency, userId);
    }
}
