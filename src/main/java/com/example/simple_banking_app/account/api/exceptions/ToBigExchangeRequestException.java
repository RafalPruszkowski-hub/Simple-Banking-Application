package com.example.simple_banking_app.account.api.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.BAD_REQUEST)
public class ToBigExchangeRequestException extends RuntimeException {

    public ToBigExchangeRequestException(String message) {
        super(message);
    }

    public ToBigExchangeRequestException(String message, Throwable cause) {
        super(message, cause);
    }
}
