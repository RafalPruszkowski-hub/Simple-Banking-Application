package com.example.simple_banking_app.users.api;

import com.example.simple_banking_app.users.api.dto.CreateUser;
import com.example.simple_banking_app.users.api.dto.User;

public interface UserFacade {
    User create(CreateUser createUser);

    User getUserByPesel(String pesel);
}
