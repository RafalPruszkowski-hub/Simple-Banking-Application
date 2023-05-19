package com.example.simple_banking_app.account;

import com.example.simple_banking_app.account.api.AccountFacade;
import com.example.simple_banking_app.account.api.dto.Account;
import com.example.simple_banking_app.account.api.dto.CreateAccount;

import java.util.UUID;

class AccountFacadeImpl implements AccountFacade {
    private final CreateAccountUseCase createAccountUseCase;
    private final GetAccountForUserUseCase getAccountForUserUseCase;

    AccountFacadeImpl(CreateAccountUseCase createAccountUseCase, GetAccountForUserUseCase getAccountForUserUseCase) {
        this.createAccountUseCase = createAccountUseCase;
        this.getAccountForUserUseCase = getAccountForUserUseCase;
    }

    @Override
    public Account getAccountsForUserId(UUID userId) {
        return getAccountForUserUseCase.execute(userId);
    }

    @Override
    public void createAccountsForUserId(CreateAccount createAccount) {
        createAccountUseCase.execute(createAccount);
    }
}
