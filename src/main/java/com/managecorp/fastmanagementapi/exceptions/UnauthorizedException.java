package com.managecorp.fastmanagementapi.exceptions;

public class UnauthorizedException extends RuntimeException {
    public UnauthorizedException (String message) {
        super(message);
    }
}