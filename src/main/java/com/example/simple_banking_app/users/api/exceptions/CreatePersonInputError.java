package com.example.simple_banking_app.users.api.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;


@ResponseStatus(value = HttpStatus.BAD_REQUEST)
public class CreatePersonInputError extends RuntimeException {
    public CreatePersonInputError(String message) {
        super(message);
    }

    public CreatePersonInputError(String message, Throwable cause) {
        super(message, cause);
    }
}
