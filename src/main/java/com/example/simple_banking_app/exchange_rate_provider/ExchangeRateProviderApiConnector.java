package com.example.simple_banking_app.exchange_rate_provider;

import com.example.simple_banking_app.account.api.dto.CurrencyType;

import java.util.Optional;

interface ExchangeRateProviderApiConnector {
    Optional<ExchangeRateNBPApiResponse> getExchangeRate(CurrencyType to);

}
