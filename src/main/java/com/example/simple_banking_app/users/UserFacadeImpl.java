package com.example.simple_banking_app.users;

import com.example.simple_banking_app.users.api.dto.CreateUser;
import com.example.simple_banking_app.users.api.dto.User;
import com.example.simple_banking_app.users.api.UserFacade;

import java.util.UUID;

class UserFacadeImpl implements UserFacade {
    private final CreateUserUseCase createUserUseCase;
    private final GetUserUseCase getUserUseCase;

    UserFacadeImpl(CreateUserUseCase createUserUseCase, GetUserUseCase getUserUseCase) {
        this.createUserUseCase = createUserUseCase;
        this.getUserUseCase = getUserUseCase;
    }

    @Override
    public User create(CreateUser createUser) {
        var userId = createUserUseCase.execute(createUser);
        return getUser(userId);
    }

    @Override
    public User getUser(UUID userId) {
        return getUserUseCase.execute(userId);
    }
}
