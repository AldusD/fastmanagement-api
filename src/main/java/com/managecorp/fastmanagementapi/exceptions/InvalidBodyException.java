package com.managecorp.fastmanagementapi.exceptions;

public class InvalidBodyException extends RuntimeException {
    public InvalidBodyException(String message) {
        super(message);
    }
}
