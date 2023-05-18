package com.example.simple_banking_app.exchange_rate_provider.api;


public interface ExchangeRateProviderFacade {
    ExchangeRateResponse getExchangeRate(CurrencyType to);

}