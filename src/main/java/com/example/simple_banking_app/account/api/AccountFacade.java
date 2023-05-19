package com.example.simple_banking_app.account.api;

import com.example.simple_banking_app.account.api.dto.Account;
import com.example.simple_banking_app.account.api.dto.CreateAccount;
import com.example.simple_banking_app.account.api.dto.ExchangeCurrency;

public interface AccountFacade {

    Account getAccountForUserPesel(String userPesel);

    void createAccountsForUserId(CreateAccount createAccount);

    void exchangeCurrency(ExchangeCurrency transfer, String userPesel);
}
