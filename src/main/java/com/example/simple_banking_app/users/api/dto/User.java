package com.example.simple_banking_app.users.api.dto;


import com.example.simple_banking_app.account.api.dto.Account;
import io.soabase.recordbuilder.core.RecordBuilder;

@RecordBuilder
public record User(String name, String surname, String pesel, Account account) {
}
