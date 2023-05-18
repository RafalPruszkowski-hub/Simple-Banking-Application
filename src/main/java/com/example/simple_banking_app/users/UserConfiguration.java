package com.example.simple_banking_app.users;

import com.example.simple_banking_app.account.api.AccountFacade;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
class UserConfiguration {

    @Bean
    UserRepository userRepository(JpaUserRepository jpaUserRepository) {
        return new UserRepositoryImpl(jpaUserRepository);
    }

    @Bean
    CreateUserUseCase createUserUseCase(UserRepository userRepository, AccountFacade accountFacade) {
        return new CreateUserUseCase(userRepository, accountFacade);
    }

    @Bean
    GetUserUseCase getUserUseCase(UserRepository userRepository, AccountFacade accountFacade) {
        return new GetUserUseCase(userRepository, accountFacade);
    }

    @Bean
    UserFacadeImpl userFacade(CreateUserUseCase createUserUseCase, GetUserUseCase getUserUseCase) {
        return new UserFacadeImpl(createUserUseCase, getUserUseCase);
    }
}
