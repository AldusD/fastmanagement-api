package com.managecorp.fastmanagementapi.exceptions;

public class ConflictException extends RuntimeException {
    public ConflictException (String message) {
        super(message);
    }
}
