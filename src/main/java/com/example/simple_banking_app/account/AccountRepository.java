package com.example.simple_banking_app.account;

interface AccountRepository {

    AccountEntity getByUserPesel(String userPesel);

    AccountEntity save(AccountEntity userEntity);
}
