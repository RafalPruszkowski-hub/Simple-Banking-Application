package com.example.simple_banking_app.account;


import com.example.simple_banking_app.account.api.exceptions.AccountNotFound;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
class AccountRepositoryImpl implements AccountRepository {
    private final JpaAccountRepository jpaAccountRepository;

    AccountRepositoryImpl(JpaAccountRepository jpaAccountRepository) {
        this.jpaAccountRepository = jpaAccountRepository;
    }

    @Override
    public AccountEntity getByUserId(UUID userId) {
        return jpaAccountRepository.findByUserId(userId)
                .orElseThrow(() -> new AccountNotFound(String.format("Account not found for user id %s", userId)));
    }

    @Override
    public AccountEntity save(AccountEntity userEntity) {
        return jpaAccountRepository.save(userEntity);
    }
}
