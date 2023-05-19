package com.example.simple_banking_app.exchange_rate_provider.api;


import com.example.simple_banking_app.account.api.dto.CurrencyType;
import com.example.simple_banking_app.exchange_rate_provider.api.dto.ExchangeRateResponse;

public interface ExchangeRateProviderFacade {
    ExchangeRateResponse getExchangeRate(CurrencyType to);

}