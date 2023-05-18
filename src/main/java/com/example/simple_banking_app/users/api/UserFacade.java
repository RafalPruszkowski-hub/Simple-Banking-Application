package com.example.simple_banking_app.users.api;

import java.util.UUID;

public interface UserFacade {
    User create(CreateUser createUser);
    User getUser(UUID userId);
}
