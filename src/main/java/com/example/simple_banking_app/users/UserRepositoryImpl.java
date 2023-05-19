package com.example.simple_banking_app.users;


import com.example.simple_banking_app.users.api.exceptions.UserNotFound;

import java.util.UUID;


class UserRepositoryImpl implements UserRepository {
    private final JpaUserRepository jpaUserRepository;

    UserRepositoryImpl(JpaUserRepository jpaUserRepository) {
        this.jpaUserRepository = jpaUserRepository;
    }

    @Override
    public UserEntity getByUserId(UUID userId) {
        return jpaUserRepository.findById(userId).orElseThrow(() -> new UserNotFound(String.format("Not found person with id: %s ", userId)));
    }

    @Override
    public boolean findByPesel(String pesel) {
        return jpaUserRepository.existsByPesel(pesel);
    }

    @Override
    public UserEntity save(UserEntity userEntity) {
        return jpaUserRepository.save(userEntity);
    }
}
