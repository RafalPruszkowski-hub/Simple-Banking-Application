package com.example.simple_banking_app.users;

import com.example.simple_banking_app.account.api.AccountFacade;
import com.example.simple_banking_app.users.api.dto.User;
import com.example.simple_banking_app.users.api.dto.UserBuilder;

import java.util.UUID;

class GetUserUseCase {

    private final UserRepository userRepository;
    private final AccountFacade accountFacade;

    GetUserUseCase(UserRepository userRepository, AccountFacade accountFacade) {
        this.userRepository = userRepository;
        this.accountFacade = accountFacade;
    }

    User execute(UUID userId) {
        var userEntity = userRepository.getByUserId(userId);
        var account = accountFacade.getAccountsForUserId(userId);
        return UserBuilder.builder()
                .id(userEntity.getId())
                .name(userEntity.getName())
                .surname(userEntity.getSurname())
                .pesel(userEntity.getPesel())
                .account(account)
                .build();
    }
}
