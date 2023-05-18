package com.example.simple_banking_app.users;

import com.example.simple_banking_app.account.api.AccountFacade;
import com.example.simple_banking_app.users.api.User;
import jakarta.transaction.Transactional;

@Transactional
class CreateUserUseCase {
    private final UserRepository userRepository;
    private final AccountFacade accountFacade;

    CreateUserUseCase(UserRepository userRepository, AccountFacade accountFacade) {
        this.userRepository = userRepository;
        this.accountFacade = accountFacade;
    }

    public User execute() {
        return null;
    }
}
