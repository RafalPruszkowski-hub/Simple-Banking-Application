package com.example.simple_banking_app.account.api.dto;

import io.soabase.recordbuilder.core.RecordBuilder;

import java.util.List;

@RecordBuilder
public record Account(List<CurrencyAccount> currencyAccounts) {

}
