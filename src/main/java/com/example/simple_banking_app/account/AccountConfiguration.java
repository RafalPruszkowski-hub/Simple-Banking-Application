package com.example.simple_banking_app.account;

import com.example.simple_banking_app.account.api.AccountFacade;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
class AccountConfiguration {

    @Bean
    AccountRepository accountRepository(JpaAccountRepository jpaAccountRepository) {
        return new AccountRepositoryImpl(jpaAccountRepository);
    }

    @Bean
    CreateAccountUseCase createAccountUseCase(AccountRepository accountRepository) {
        return new CreateAccountUseCase(accountRepository);
    }

    @Bean
    GetAccountForUserUseCase getAccountForUserUseCase(AccountRepository accountRepository) {
        return new GetAccountForUserUseCase(accountRepository);
    }

    @Bean
    AccountFacade accountFacade(CreateAccountUseCase createAccountUseCase, GetAccountForUserUseCase getAccountForUserUseCase) {
        return new AccountFacadeImpl(createAccountUseCase, getAccountForUserUseCase);
    }
}
