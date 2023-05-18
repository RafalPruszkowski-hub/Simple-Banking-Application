package com.example.simple_banking_app.exchange_rate_provider;

import java.util.List;

record ExchangeRateNBPApiResponse(List<ExchangeRate> rates) {

    record ExchangeRate(double mid) {
    }
}
