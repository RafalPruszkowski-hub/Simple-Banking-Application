package com.example.simple_banking_app.account.api;

import com.example.simple_banking_app.account.api.dto.Account;
import com.example.simple_banking_app.account.api.dto.CreateAccount;
import com.example.simple_banking_app.account.api.dto.ExchangeCurrency;

import java.util.UUID;

public interface AccountFacade {

    Account getAccountsForUserId(UUID userId);

    void createAccountsForUserId(CreateAccount createAccount);

    void exchangeCurrency(ExchangeCurrency transfer, UUID userId);
}
