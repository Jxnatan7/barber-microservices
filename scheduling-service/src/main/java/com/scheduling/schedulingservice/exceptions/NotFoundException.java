package com.scheduling.schedulingservice.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class NotFoundException extends RuntimeException {
    public NotFoundException() {
        super("scheduling-not-found");
    }

    public NotFoundException(String message, Throwable cause) {
        super(message, cause);
    }
}