package com.barber.companyservice.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class EmailException extends RuntimeException {
    public EmailException() {
        super("Email-already-in-use");
    }

    public EmailException(String message, Throwable cause) {
        super(message, cause);
    }
}
