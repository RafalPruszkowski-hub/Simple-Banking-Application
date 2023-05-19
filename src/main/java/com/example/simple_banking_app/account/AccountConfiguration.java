package com.example.simple_banking_app.account;

import com.example.simple_banking_app.account.api.AccountFacade;
import com.example.simple_banking_app.exchange_rate_provider.api.ExchangeRateProviderFacade;
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
    ExchangeCurrencyUseCase exchangeCurrencyUseCase(AccountRepository accountRepository,
                                                    ExchangeRateProviderFacade exchangeRateProviderFacade) {
        return new ExchangeCurrencyUseCase(accountRepository, exchangeRateProviderFacade);
    }

    @Bean
    AccountFacade accountFacade(CreateAccountUseCase createAccountUseCase, GetAccountForUserUseCase getAccountForUserUseCase,
                                ExchangeCurrencyUseCase exchangeCurrencyUseCase) {
        return new AccountFacadeImpl(createAccountUseCase, getAccountForUserUseCase, exchangeCurrencyUseCase);
    }
}
