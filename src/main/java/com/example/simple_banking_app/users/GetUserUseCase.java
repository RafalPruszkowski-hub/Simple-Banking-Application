package com.example.simple_banking_app.users;

import com.example.simple_banking_app.account.api.AccountFacade;
import com.example.simple_banking_app.users.api.dto.User;
import com.example.simple_banking_app.users.api.dto.UserBuilder;

class GetUserUseCase {

    private final UserRepository userRepository;
    private final AccountFacade accountFacade;

    GetUserUseCase(UserRepository userRepository, AccountFacade accountFacade) {
        this.userRepository = userRepository;
        this.accountFacade = accountFacade;
    }

    User execute(String pesel) {
        var userEntity = userRepository.getByPesel(pesel);
        var account = accountFacade.getAccountForUserPesel(pesel);
        return UserBuilder.builder()
                .name(userEntity.getName())
                .surname(userEntity.getSurname())
                .pesel(userEntity.getPesel())
                .account(account)
                .build();
    }
}
