package com.example.simple_banking_app.account.api.dto;

public record ExchangeCurrency(CurrencyType from, CurrencyType to, double amount) {
}
