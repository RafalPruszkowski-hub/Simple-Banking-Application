package com.example.simple_banking_app.account.api;

import java.util.List;

public interface AccountFacade {

    List<Account> getAccountsForUserId();

    List<Account> createAccountsForUserId();
}
