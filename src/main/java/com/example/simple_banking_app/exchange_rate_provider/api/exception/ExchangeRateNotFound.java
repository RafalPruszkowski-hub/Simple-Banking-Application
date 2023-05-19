package com.example.simple_banking_app.exchange_rate_provider.api.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class ExchangeRateNotFound extends RuntimeException {

    public ExchangeRateNotFound(String message) {
        super(message);
    }

    public ExchangeRateNotFound(String message, Throwable cause) {
        super(message, cause);
    }
}
