package com.example.simple_banking_app.exchange_rate_provider;

import com.example.simple_banking_app.account.api.dto.CurrencyType;
import com.example.simple_banking_app.exchange_rate_provider.api.ExchangeRateProviderFacade;
import com.example.simple_banking_app.exchange_rate_provider.api.dto.ExchangeRate;

final class ExchangeRateProviderFacadeImpl implements ExchangeRateProviderFacade {
    private final ExchangeRateProviderUseCase exchangeRateProviderUseCase;

    ExchangeRateProviderFacadeImpl(ExchangeRateProviderUseCase exchangeRateProviderUseCase) {
        this.exchangeRateProviderUseCase = exchangeRateProviderUseCase;
    }

    @Override
    public ExchangeRate getExchangeRate(CurrencyType to) {
        return exchangeRateProviderUseCase.getExchangeRate(to);
    }
}
