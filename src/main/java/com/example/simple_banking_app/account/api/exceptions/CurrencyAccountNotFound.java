package com.example.simple_banking_app.account.api.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class CurrencyAccountNotFound extends RuntimeException {

    public CurrencyAccountNotFound(String message) {
        super(message);
    }

    public CurrencyAccountNotFound(String message, Throwable cause) {
        super(message, cause);
    }
}
