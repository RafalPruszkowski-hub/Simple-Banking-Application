package com.example.simple_banking_app.account;

import java.util.UUID;

interface AccountRepository {

    AccountEntity getByUserId(UUID userId);

    AccountEntity save(AccountEntity userEntity);
}
