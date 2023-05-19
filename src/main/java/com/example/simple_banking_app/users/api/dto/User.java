package com.example.simple_banking_app.users.api.dto;


import com.example.simple_banking_app.account.api.dto.Account;
import io.soabase.recordbuilder.core.RecordBuilder;

import java.util.List;
import java.util.UUID;

@RecordBuilder
public record User(UUID id, String name, String surname, String pesel, Account account) {
}
