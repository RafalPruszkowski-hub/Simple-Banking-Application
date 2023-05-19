package com.example.simple_banking_app.account.api.dto;


import io.soabase.recordbuilder.core.RecordBuilder;

@RecordBuilder
public record CreateAccount(String pesel, double statingAmountOfMoney) {
}
