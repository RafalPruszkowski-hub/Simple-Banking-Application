package com.example.simple_banking_app.account.api.dto;

import io.soabase.recordbuilder.core.RecordBuilder;

@RecordBuilder
public record CurrencyAccount(CurrencyType currencyType, double amount) {
}
