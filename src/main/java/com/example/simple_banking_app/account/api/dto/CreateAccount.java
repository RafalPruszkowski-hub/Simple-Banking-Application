package com.example.simple_banking_app.account.api.dto;


import io.soabase.recordbuilder.core.RecordBuilder;

import java.util.UUID;

@RecordBuilder
public record CreateAccount(UUID userId, double statingAmountOfMoney) {
}
