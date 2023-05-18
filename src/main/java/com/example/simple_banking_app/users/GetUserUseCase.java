package com.example.simple_banking_app.users;

import com.example.simple_banking_app.account.api.AccountFacade;
import com.example.simple_banking_app.users.api.User;

public class GetUserUseCase {

    private final UserRepository userRepository;
    private final AccountFacade accountFacade;

    GetUserUseCase(UserRepository userRepository, AccountFacade accountFacade) {
        this.userRepository = userRepository;
        this.accountFacade = accountFacade;
    }

    public User execute() {
        return null;
    }
}
