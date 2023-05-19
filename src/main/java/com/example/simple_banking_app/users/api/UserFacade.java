package com.example.simple_banking_app.users.api;

import com.example.simple_banking_app.users.api.dto.CreateUser;
import com.example.simple_banking_app.users.api.dto.User;

import java.util.UUID;

public interface UserFacade {
    User create(CreateUser createUser);
    User getUser(UUID userId);
}
