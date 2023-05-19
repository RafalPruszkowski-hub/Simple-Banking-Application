package com.example.simple_banking_app.account;

import com.example.simple_banking_app.account.api.AccountFacade;
import com.example.simple_banking_app.account.api.dto.Account;
import com.example.simple_banking_app.account.api.dto.CreateAccount;
import com.example.simple_banking_app.account.api.dto.ExchangeCurrency;

class AccountFacadeImpl implements AccountFacade {
    private final CreateAccountUseCase createAccountUseCase;
    private final GetAccountForUserPeselUseCase getAccountForUserPeselUseCase;
    private final ExchangeCurrencyUseCase exchangeCurrencyUseCase;

    AccountFacadeImpl(CreateAccountUseCase createAccountUseCase, GetAccountForUserPeselUseCase getAccountForUserPeselUseCase, ExchangeCurrencyUseCase exchangeCurrencyUseCase) {
        this.createAccountUseCase = createAccountUseCase;
        this.getAccountForUserPeselUseCase = getAccountForUserPeselUseCase;
        this.exchangeCurrencyUseCase = exchangeCurrencyUseCase;
    }

    public Account getAccountForUserPesel(String userPesel) {
        return getAccountForUserPeselUseCase.execute(userPesel);
    }

    @Override
    public void createAccountsForUserId(CreateAccount createAccount) {
        createAccountUseCase.execute(createAccount);
    }

    @Override
    public void exchangeCurrency(ExchangeCurrency exchangeCurrency, String userPesel) {
        exchangeCurrencyUseCase.execute(exchangeCurrency, userPesel);
    }
}
