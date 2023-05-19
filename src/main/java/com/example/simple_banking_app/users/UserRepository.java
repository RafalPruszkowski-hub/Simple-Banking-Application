package com.example.simple_banking_app.users;

interface UserRepository {
    UserEntity getByPesel(String userPesel);
    boolean existsByPesel(String pesel);
    UserEntity save(UserEntity userEntity);
}
