package com.example.simple_banking_app.users;

import java.util.UUID;

interface UserRepository {
    UserEntity getByUserId(UUID userId);
    boolean findByPesel(String pesel);
    UserEntity save(UserEntity userEntity);
}
