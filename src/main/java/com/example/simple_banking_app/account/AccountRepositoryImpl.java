package com.example.simple_banking_app.account;


import com.example.simple_banking_app.account.api.exceptions.AccountNotFound;
import org.springframework.stereotype.Repository;

@Repository
class AccountRepositoryImpl implements AccountRepository {
    private final JpaAccountRepository jpaAccountRepository;

    AccountRepositoryImpl(JpaAccountRepository jpaAccountRepository) {
        this.jpaAccountRepository = jpaAccountRepository;
    }

    @Override
    public AccountEntity getByUserPesel(String userPesel) {
        return jpaAccountRepository.findByUserPesel(userPesel)
                .orElseThrow(() -> new AccountNotFound(String.format("Account not found for user pesel %s", userPesel)));
    }

    @Override
    public AccountEntity save(AccountEntity userEntity) {
        return jpaAccountRepository.save(userEntity);
    }
}
