package com.example.simple_banking_app.users.api;


import com.example.simple_banking_app.account.api.Account;

import java.util.List;
import java.util.UUID;

public record User(UUID id, String name, String surname, String pesel, List<Account> accounts) {
}
