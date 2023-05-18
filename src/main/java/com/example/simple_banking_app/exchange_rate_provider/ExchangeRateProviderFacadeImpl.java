package com.example.simple_banking_app.exchange_rate_provider;

import com.example.simple_banking_app.exchange_rate_provider.api.CurrencyType;
import com.example.simple_banking_app.exchange_rate_provider.api.ExchangeRateProviderFacade;
import com.example.simple_banking_app.exchange_rate_provider.api.ExchangeRateResponse;

final class ExchangeRateProviderFacadeImpl implements ExchangeRateProviderFacade {
    private final ExchangeRateProviderUseCase exchangeRateProviderUseCase;

    ExchangeRateProviderFacadeImpl(ExchangeRateProviderUseCase exchangeRateProviderUseCase) {
        this.exchangeRateProviderUseCase = exchangeRateProviderUseCase;
    }

    @Override
    public ExchangeRateResponse getExchangeRate(CurrencyType to) {
        return exchangeRateProviderUseCase.getExchangeRate(to);
    }
}
