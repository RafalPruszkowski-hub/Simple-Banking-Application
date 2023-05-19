package com.example.simple_banking_app.users;


import com.example.simple_banking_app.users.api.exceptions.UserNotFound;


class UserRepositoryImpl implements UserRepository {
    private final JpaUserRepository jpaUserRepository;

    UserRepositoryImpl(JpaUserRepository jpaUserRepository) {
        this.jpaUserRepository = jpaUserRepository;
    }

    @Override
    public UserEntity getByPesel(String pesel) {
        return jpaUserRepository.findByPesel(pesel).orElseThrow(() -> new UserNotFound(String.format("Not found person with pesel: %s ", pesel)));
    }

    @Override
    public boolean existsByPesel(String userPesel) {
        return jpaUserRepository.existsByPesel(userPesel);
    }

    @Override
    public UserEntity save(UserEntity userEntity) {
        return jpaUserRepository.save(userEntity);
    }
}
