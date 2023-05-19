package com.example.simple_banking_app.users;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
interface JpaUserRepository extends JpaRepository<UserEntity, UUID> {
    boolean existsByPesel(String pesel);

    Optional<UserEntity> findByPesel(String pesel);
}
