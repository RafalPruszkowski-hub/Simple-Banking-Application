package com.example.simple_banking_app.account;

import com.example.simple_banking_app.account.api.AccountFacade;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
class AccountConfiguration {

    @Bean
    AccountFacade accountFacade() {
        return new AccountFacadeImpl();
    }
}
