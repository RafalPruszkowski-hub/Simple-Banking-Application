package com.example.simple_banking_app.account.api;

import com.example.simple_banking_app.exchange_rate_provider.api.CurrencyType;

public record Account(CurrencyType currencyType, double amount) {

}
