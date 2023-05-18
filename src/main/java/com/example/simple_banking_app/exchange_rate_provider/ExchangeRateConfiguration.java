package com.example.simple_banking_app.exchange_rate_provider;

import com.example.simple_banking_app.exchange_rate_provider.api.ExchangeRateProviderFacade;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
class ExchangeRateConfiguration {
    @Bean
    ExchangeRateProviderUseCase exchangeRateProviderUseCase(ExchangeRateProviderApiConnector exchangeRateProviderApiConnector) {
        return new ExchangeRateProviderUseCase(exchangeRateProviderApiConnector);
    }

    @Bean
    public ExchangeRateProviderFacade exchangeRateProviderFacade(ExchangeRateProviderUseCase exchangeRateProviderUseCase) {
        return new ExchangeRateProviderFacadeImpl(exchangeRateProviderUseCase);
    }
}
